printjson(db.people.deleteMany( 
	{ 
		"height" : 
				{ 
					$gt : "190.00"
				} 
	} 
))