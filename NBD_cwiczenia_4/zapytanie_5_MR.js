var mapFunction1 = function() {
	if(this.sex === "Female"&& this.nationality === "Poland"){
		for(var i = 0; i < this.credit.length; i++){
			var key = this.credit[i].currency;
			var value = { count: 1, sumBal: parseFloat(this.credit[i].balance)};
			emit(key, value);
		};
	}
};

var reduceFunction1 = function(key, value) {
	reducedVal = {count:0, sum: 0};
	
	reducedVal.count = Array.sum(value.map(x => x.count));
	reducedVal.sum = Array.sum(value.map(x => x.sumBal));
	
    return reducedVal;
};

var finalizeFunction = function(key, reducedVal){
	reducedVal.avg = reducedVal.sum/reducedVal.count;	
	return {reducedVal};
};

printjson(db.people.mapReduce(
   mapFunction1,
   reduceFunction1,
   { out: { inline: 1}, finalize: finalizeFunction}
));