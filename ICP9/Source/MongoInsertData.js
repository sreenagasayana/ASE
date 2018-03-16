// Required Mongo Client
var mongoClient = require('mongodb').MongoClient;
var assert = require('assert');
// Mongo DB URL.
var url = 'mongodb://root:root@ds215089.mlab.com:15089/asedemo';

// Mongo Insert Document Function Call.
var mongoInsertDocument = function(db, callback) {
    // Inserting Multiple Records
    db.collection('users').insertMany([{
        "userId" : 16258790,
        "firstName" : "Hari",
        "lastName": "Manasa",
        "mobileNumber" : "224-279-1234",
        "city" : "Kansas"
    },
        {
            "userId" : 16258791,
            "firstName" : "Kranthi",
            "lastName": "Kumar",
            "mobileNumber" : "224-279-1235",
            "city" : "Chicago"
        },{
            "userId" : 16261475,
            "firstName" : "Harish",
            "lastName": "Sree",
            "mobileNumber" : "224-279-1234",
            "city" : "Texas"
        },
        {
            "userId" : 16261476,
            "firstName" : "Sreenaga",
            "lastName": "Sayana",
            "mobileNumber" : "224-279-1237",
            "city" : "Dallas"
        },
        {
            "userId" : 16261477,
            "firstName" : "Sreenaga",
            "lastName": "Jayanthi",
            "mobileNumber" : "224-279-1234",
            "city" : "Michigan"
        }], function(err, result) {
        assert.equal(err, null);
        console.log("Inserted a document into the collection.");
        callback();
    });
};

mongoClient.connect(url, function(err, client) {
    assert.equal(null, err);
    // Sending Database Name to the Insert Function.
    var database = client.db('asedemo')
    mongoInsertDocument(database, function() {
        client.close();
    });
});