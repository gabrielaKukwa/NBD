var mapFunction1 = function() {
	emit(this.job, 1);
};

var reduceFunction1 = function(id, balance) {
   return 1;
};

printjson(db.people.mapReduce(
   mapFunction1,
   reduceFunction1,
   { out: { inline: 1}}
));