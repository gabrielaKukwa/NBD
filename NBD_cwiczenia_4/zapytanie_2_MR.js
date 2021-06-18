var mapFunction1 = function() {
	for(var i = 0; i < this.credit.length; i++){
		emit(this.credit[i].currency, parseFloat(this.credit[i].balance));
	}
};

var reduceFunction1 = function(id, balance) {
   return Array.sum(balance);
};

printjson(db.people.mapReduce(
   mapFunction1,
   reduceFunction1,
   { out: { inline: 1}}
));