const express = require('express');
const jquery = require('jQuery');

const app = express()
const port = 8000;

app.get('/', (req, res) => res.send('Hello Boozer!'))

app.get('/harry', function (req, res) {
    res.send('<b>Hello Harry!</b>'); 
    console.log("message sent")
})

/*
app.get('/harry', (req, res) => res.send('Hello Harry!'))
*/

console.log('Test app listening on port ${port}!');
app.listen(port);