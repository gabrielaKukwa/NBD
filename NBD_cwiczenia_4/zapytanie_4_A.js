printjson(db.people.aggregate
(
	[ 
		{ $group: 
			{ _id: "$nationality", 
			  avgBmi:{ $avg: { $multiply : [10000, {$divide: [ {$toDouble:"$weight"},{$multiply:[{$toDouble:"$height"}, {$toDouble:"$height"} ] } ]}]}},
			  minBmi:{ $min: { $multiply : [10000, {$divide: [ {$toDouble:"$weight"},{$multiply:[{$toDouble:"$height"}, {$toDouble:"$height"} ] } ]}]}},
			  maxBmi:{ $max: { $multiply : [10000, {$divide: [ {$toDouble:"$weight"},{$multiply:[{$toDouble:"$height"}, {$toDouble:"$height"} ] } ]}]}}   
			}   
		}   
	]
).toArray())