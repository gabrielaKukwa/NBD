printjson(db.people.insertOne(
	{
		"sex" : "Female",
		"first_name" : "Gabriela",
		"last_name" : "Kukwa",
		"job" : "Software Engineer",
		"email" : "s23424@pjwstk.edu.pl",
		"location" : {
			"city" : "Warsaw",
			"address" : {
				"streetname" : "XXX",
				"streetnumber" : "YY"
			}
		},
		"description" : "lorem ipsum",
		"height" : "159.99",
		"weight" : "99.01",
		"birth_date" : "1996-05-21T19:55:57Z",
		"nationality" : "Poland",
		"credit" : [
			{
				"type" : "revolut",
				"number" : "1111111111111111",
				"currency" : "USD",
				"balance" : "1000.0"
			}
		]
	},
))