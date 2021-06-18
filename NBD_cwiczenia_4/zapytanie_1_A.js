printjson(db.people.aggregate
(
	[
		{$group:
			{ "_id": "$sex",
				heightAvg: { $avg:{ $toDouble: "$height"}},
				weightAvg: { $avg: { $toDouble:"$weight" }}
			}
		}
	]
).toArray())
