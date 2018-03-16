// Required Mongo Client
var mongoClient = require('mongodb').MongoClient;
var assert = require('assert');
// Mongo DB URL.
var url = 'mongodb://root:root@ds215089.mlab.com:15089/asedemo';

mongoClient.connect(url, function(err, client) {
    assert.equal(null, err);
    // Sending Database Name to the Get Functions.
    var database = client.db('asedemo')
    mongoRetrieveByPhoneNumber(database, function() {
        client.close();
    });
});

// Retrieving User Details by PhoneNumber
var mongoRetrieveByPhoneNumber = function (db,callback) {
    var dataRetrieved = db.collection('users').find({"mobileNumber":"224-279-1234"});
    // Iterating the Retrieved Data
    var detail=0;
    dataRetrieved.each(function(err,document) {
        assert.equal(err,null);
        if(document != null)
        {
            detail = detail+1;
            console.log("\nUser Detail "+detail+" for the Searched Mobile Number\n");
            console.log("User Id : " + document.userId);
            console.log("User First Name : " + document.firstName);
            console.log("User Last Name : " + document.lastName);
            console.log("User City : " + document.city);
        }else{
            // If no Documents are present callback()
            callback();
        }
    });
}