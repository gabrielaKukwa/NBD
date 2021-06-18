printjson(db.people.aggregate
(
	[
		{$unwind: "$credit"},
		{$group:
			{ _id: "$credit.currency", 
			  hajs: { 
						$sum:{ $toDouble: "$credit.balance"}
					} 
			}
		}
	]
).toArray())
