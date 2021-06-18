var mapFunction1 = function() {
	var key = this.nationality;
	var value = {count:1, sumBmi: 10000*this.weight/(this.height*this.height), minBmi: 10000*this.weight/(this.height*this.height), maxBmi: 10000*this.weight/(this.height*this.height) };
	emit(key, value);
};


var reduceFunction1 = function(key, value) {
	reducedVal = {count:0, sumBmi: 0, minBmi: 0, maxBmi: 0};

	reducedVal.count = Array.sum(value.map(x => x.count));
	reducedVal.sumBmi = Array.sum(value.map(x => x.sumBmi));
	reducedVal.minBmi = Math.min.apply(Math, value.map(x => x.minBmi));
	reducedVal.maxBmi = Math.max.apply(Math, value.map(x => x.maxBmi));

	return reducedVal;
};


var finalizeFunction = function(key, reducedVal){
	reducedVal.avgBmi = reducedVal.sumBmi/reducedVal.count;	
	return {reducedVal};
};

printjson(db.people.mapReduce(
   mapFunction1,
   reduceFunction1,
   { out: { inline: 1}, finalize: finalizeFunction}
));


