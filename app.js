
const express = require("express");
const app = express();

const service = require("./service");

app.use(express.json());
app.use(express.urlencoded({extended: false}));
//app.use(express.static(path.join(__dirname, 'public')));



app.get('/play', function(req, res) {
    let raw = req.query.board;
    
    let preboard = service.prepare(raw);

    let board = service.play(preboard);

    res.send(board.join(''));
});


// catch 404 and forward to error handler
app.use(function (req, res, next) {
    res.status(400).send('Invalid request');
});

// error handler
app.use(function (err, req, res, next) {
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};

    // render the error page
    res.status(err.status || 400);//bad request
    res.send(err.message);
   // res.render('error');
});

let port = process.env.PORT ||3000
app.listen(port, () => console.log('Listening on port ',port)); 