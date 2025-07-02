
**Use Case**
I want to board a train from London to France. The train ticket will cost $5.

1. Buy ticket API where you can submit a purchase for a ticket. Details included in the receipt are:
	 a) From, To, User , price paid.
	(i) User should include first and last name, email address
	[http://localhost:8080/view-seat/:user_id ]
	[http://localhost:8080/buy-ticket/:user_id]
2. The user is allocated a seat in the train. Assume the train has only 2 sections, section A and section B.
3. An API that shows the details of the receipt for the user
[http://localhost:8080/receipts/:user_id]
4. An API that lets you view the users and seat they are allocated by the requested section
[http://localhost:8080/passenger/:train_number]
4. An API to remove a user from the train
[http://localhost:8080/off-board/:user_id]
5. An API to modify a user's seat
[http://localhost:8080/modify-seat/:user_id]

**Resource**
1. Github : https://github.com/thangamudyg/trs.git
2. API Spec : https://app.swaggerhub.com/apis/THANGAMUDYGURUSAMY_1/trs/1.0.1
   https://github.com/thangamudyg/trs/blob/master/src/main/resources/apispec.yml
3. I have used Spring H2 in memory data. Console : http://localhost:8080/h2console
2. Postman Collection : https://api.postman.com/collections/34091245-f6b7a718-fc39-4bae-9714-c6cc74e8ace9?access_key=PMAT-01HTXWM8PJXSE2X27EZ5G22VYY
3. Demo video attached : https://drive.google.com/file/d/1VUJR5JIBW7THJoJmpQmelQwRRtcLiGZ3/view?usp=drive_web

**Limitations & Assumption**
1. Only one train & one route (London -> France) but I have implemented an API to support multiple trains & routes . Only train & route data to be inserted inmemory
2. User Auth not included.
3. input field validation
4. API specific client error response codes
