var mapFunction1 = function() {
	var key = this.sex;
	var value = {count:1, weight: parseFloat(this.weight), height: parseFloat(this.height)};
    emit(key, value);
};

var reduceFunction1 = function(key, value) {
	reducedVal = {count:0, weight: 0, height: 0};

	for (var i=0; i < value.length; i++){
		reducedVal.count += value[i].count;
		reducedVal.weight += value[i].weight;
		reducedVal.height += value[i].height;
	}

	return reducedVal;
};


var finalizeFunction = function(key, reducedVal){
	reducedVal.heightAvg = reducedVal.height/reducedVal.count;
    reducedVal.weightAvg = reducedVal.weight/reducedVal.count;	
	return {reducedVal};
};

printjson(db.people.mapReduce(
   mapFunction1,
   reduceFunction1,
   { out: { inline: 1}, finalize: finalizeFunction}
));


