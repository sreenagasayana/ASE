// Importing MongoClient
var mongoClient = require('mongodb').MongoClient;

// Importing Assert
var assert = require('assert');

// Mongo DB Url
var url = 'mongodb://sreenaga:Sreehari47*@ds215089.mlab.com:15089/asedemo';

//
mongoClient.connect(url, function (err,db) {
    assert.equal(null, err);
    console.log("Successfully Connected to Server");
   db.close();
})