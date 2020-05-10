This is a sample ecommerce application which deals with items and orders.

It has rest apis to access the data.

Use the script.sql file to create databases and tables.

Update the username and password in application.properties.

API:

1.  POST /addItems (using for data creation-  Single Item)

RequestHeader:
    "Content-Type" :"application/json"
Request Body:
    {
    	"items":
    	[
        {
         "itemDescription": "Desc1",
          "itemQuantity": "10",
          "itemPrice": 300
        }
       ]
    }

Response:
[
    {
        "itemId": 153063493134400,
        "itemDescription": "Desc1",
        "itemQuantity": 10,
        "message": "Item Added",
        "itemPrice": 300
    }
]

2.  POST /addItems (using for data creation-  Multiple Item)

RequestHeader:
 "Content-Type" :"application/json"
Request Body:
{
	"items":
	[
    {
     "itemDescription": "Desc1",
      "itemQuantity": "10",
     "itemPrice": 300
    },
    {
     "itemDescription": "Desc2",
      "itemQuantity": "11",
      "itemPrice": 300
    },
    {
     "itemDescription": "Desc3",
      "itemQuantity": "12",
      "itemPrice": 300
    },
    {
     "itemDescription": "Desc4",
      "itemQuantity": "13",
      "itemPrice": 300
    },
    {
     "itemDescription": "Desc5",
      "itemQuantity": "14",
      "itemPrice": 300
    }
  ]
}

Response:
[
    {
        "itemId": 153063493134400,
        "itemDescription": "Desc1",
        "itemQuantity": 10,
        "message": "Item Added",
        "itemPrice": 300
    },
    {
        "itemId": 153063850633400,
        "itemDescription": "Desc2",
        "itemQuantity": 11,
        "message": "Item Added",
        "itemPrice": 300
    },
    {
        "itemId": 153063957883500,
        "itemDescription": "Desc3",
        "itemQuantity": 12,
        "message": "Item Added",
        "itemPrice": 300
    },
    {
        "itemId": 153064112049900,
        "itemDescription": "Desc4",
        "itemQuantity": 13,
        "message": "Item Added",
        "itemPrice": 300
    },
    {
        "itemId": 153064251112700,
        "itemDescription": "Desc5",
        "itemQuantity": 14,
        "message": "Item Added",
        "itemPrice": 300
    }
]


3. POST /addItems (using for data updation- Single Item)

RequestHeader:
"Content-Type" :"application/json"
Request Body:

{
	"items":
	[
    {
    "itemId": 153063493134400,
     "itemDescription": "Desc1",
      "itemQuantity": "10",
      "itemPrice": 300
    }
   ]
}
  
  Response:
[
    {
        "itemId": 153063493134400,
        "itemDescription": "Desc1",
        "itemQuantity": 10,
        "message": "Item Updated",
        "itemPrice": 300
    }
]


4. POST /addItems  (using for data updation and data creation - if id is present it will be updated else created)

RequestHeader:
"Content-Type" :"application/json"
{
	"items":
	[
    {
	"itemId": 156887992868300,
     "itemDescription": "Desc1",
      "itemQuantity": "11",
    "itemPrice": 300
    },
    {
    "itemId": 156888164025900,
     "itemDescription": "Desc2",
      "itemQuantity": "1",
      "itemPrice": 300
    },
    {
     "itemDescription": "Desc3",
      "itemQuantity": "12",
      "itemPrice": 300
    }
     ]
}
   
 Response (For 1st and 2nd item id remains same, as they are updated. New id is auto created for third item): 
[
    {
        "itemId": 156887992868300,
        "itemDescription": "Desc1",
        "itemQuantity": 11,
        "message": "Item Updated",
        "itemPrice": 300
    },
    {
        "itemId": 156888164025900,
        "itemDescription": "Desc2",
        "itemQuantity": 1,
        "message": "Item Updated",
        "itemPrice": 300
    },
    {
        "itemId": 156946115589800,
        "itemDescription": "Desc3",
        "itemQuantity": 12,
        "message": "Item Added",
        "itemPrice": 300
    }
]

5. GET /getAllItems  

Response:
[
    {
        "itemId": 153063493134400,
        "itemDescription": "Desc1",
        "itemQuantity": 10,
        "itemPrice": 300
    },
    {
        "itemId": 153063850633400,
        "itemDescription": "Desc2",
        "itemQuantity": 11,
        "itemPrice": 300
    },
    {
        "itemId": 153063957883500,
        "itemDescription": "Desc3",
        "itemQuantity": 12,
        "itemPrice": 300
    },
    {
        "itemId": 153064112049900,
        "itemDescription": "Desc4",
        "itemQuantity": 13,
        "itemPrice": 300
    },
    {
        "itemId": 153064251112700,
        "itemDescription": "Desc5",
        "itemQuantity": 14,
        "itemPrice": 300
    },
    {
        "itemId": 156887992868300,
        "itemDescription": "Desc1",
        "itemQuantity": 11,
        "itemPrice": 300
    },
    {
        "itemId": 156888164025900,
        "itemDescription": "Desc2",
        "itemQuantity": 1,
        "itemPrice": 300
    },
    {
        "itemId": 156888324137500,
        "itemDescription": "Desc3",
        "itemQuantity": 12,
        "itemPrice": 300
    },
    {
        "itemId": 156888441449900,
        "itemDescription": "Desc4",
        "itemQuantity": 12,
        "itemPrice": 300
    },
    {
        "itemId": 156888565011500,
        "itemDescription": "Desc5",
        "itemQuantity": 14,
        "itemPrice": 300
    },
    {
        "itemId": 156946115589800,
        "itemDescription": "Desc3",
        "itemQuantity": 12,
        "itemPrice": 300
    }
]

6. GET /getItem/153063493134400   (using for retrieving a specific item by id)

Response :
{
    "itemId": 153063493134400,
    "itemDescription": "Desc1",
    "itemQuantity": 10,
    "itemPrice": 300
}

7. GET  /allOrders  (used for getting all the orders)

Response:
[
    {
        "orderId": 140851527791000,
        "emailId": "abcd@abcd.com",
        "items": [
            {
                "itemId": 345685,
                "orderQuantity": 2
            },
            {
                "itemId": 345685,
                "orderQuantity": 2
            }
        ]
    },
    {
        "orderId": 140860371669100,
        "emailId": "abcd@abcd.com",
        "items": [
            {
                "itemId": 345686,
                "orderQuantity": 2
            }
        ]
    },
    {
        "orderId": 140866065645800,
        "emailId": "abcd@abcd.com",
        "items": [
            {
                "itemId": 345687,
                "orderQuantity": 2
            }
        ]
    },
    {
        "orderId": 146322003570900,
        "emailId": "abcd@abcd.com",
        "items": [
            {
                "itemId": 345687,
                "orderQuantity": 2
            }
        ]
    }
]