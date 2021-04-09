function prepare(raw){
let board = [];
    //9 chars, x,o,or space only 
    if((raw.match(/[xo ]/g) || []).length==9){
       raw.split('').forEach(element => {
           board.push(element)
       });

       //must be 0s turn - empty board or x ahead by 1
       var countx = (raw.match(/x/g) || []).length
       var counto = (raw.match(/o/g) || []).length
       if(countx-counto==1|| (countx==counto)){

        if(isGameOver('xxx',board)){ console.log('game over. won xxx',raw); new Error('Game over'); }
        
        if(isGameOver('ooo',board)){ console.log('game over. won ooo',raw); new Error('Game over'); }

        return board;


       }else{
        console.log('invalid board - wrong state',raw)
       }
       
    }else{
        console.log('invalid board - characters',raw)
    }

    throw new Error('invalid board');

}

function play(board){
        
    // if empty begin with corner center or edge if empty
    if((board.join('').match(/[ ]/g) || []).length==9){
        board[0]='o';
        return board;
    }
    //if x started play center or edge
    if((board.join('').match(/[xo]/g) || []).length==1){
        if(board[4]=' '){
            board[4]='o';
        }else{
            board[0]='o';
        }   
        return board;
    }
     //check block - if 2 in a line stop
     if(!winblock('xx',board)){
        //try edge next 
        if(!edge(board)){
          //try win
          if(!winblock('oo',board)){
            //insert any
              let blank=  board.join('').indexOf(' ')
              board[blank]='o';
          }
        
        }

        
    }
    return board;

    }
function winblock(char,board){
    //if 2 x in a row.. stop horizontals
    for(var x=0;x<9;x+=3){
    if(board[x+0]+board[x+1]==char&& board[x+2]==' '){board[x+2]='o'; return true;}
    if(board[x+0]+board[x+2]==char&& board[x+1]==' '){board[x+1]='o'; return true;}
    if(board[x+1]+board[x+2]==char&& board[x+0]==' '){board[x+0]='o'; return true;}
    }
    //if 2 x in a row.. stop vericals
    for(var x=0;x<3;x++){
    if(board[x+0]+board[x+3]==char&& board[x+6]==' '){board[x+6]='o'; return true;}
    if(board[x+0]+board[x+6]==char&& board[x+3]==' '){board[x+3]='o'; return true;}
    if(board[x+3]+board[x+6]==char&& board[x+0]==' '){board[x+0]='o'; return true;}
    }

//if 2 x in a row.. stop diagonals

    if(board[x+0]+board[x+4]==char&& board[8]==' '){board[8]='o'; return true;}
    if(board[x+0]+board[x+8]==char&& board[4]==' '){board[4]='o'; return true;}
    if(board[x+4]+board[x+8]==char&& board[0]==' '){board[0]='o'; return true;}

    if(board[x+2]+board[x+4]==char&& board[6]==' '){board[6]='o'; return true;}
    if(board[x+2]+board[x+6]==char&& board[4]==' '){board[4]='o'; return true;}
    if(board[x+4]+board[x+6]==char&& board[2]==' '){board[2]='o'; return true;}

return false;

}
function edge(board){
    // horizontals
    for(var x=0;x<9;x+=3){
    if(board[x+0]+board[x+1]=='  '&& board[x+2]!=' '){board[x+0]='o'; return true;}
    if(board[x+0]+board[x+2]=='  '&& board[x+1]!=' '){board[x+2]='o'; return true;}
    if(board[x+1]+board[x+2]=='  '&& board[x+0]!=' '){board[x+1]='o'; return true;}
    }
    // verticals
    for(var x=0;x<3;x++){
    if(board[x+0]+board[x+3]=='  '&& board[x+6]!=' '){board[x+0]='o'; return true;}
    if(board[x+0]+board[x+6]=='  '&& board[x+3]!=' '){board[x+3]='o'; return true;}
    if(board[x+3]+board[x+6]=='  '&& board[x+0]!=' '){board[x+6]='o'; return true;}
    }

return false;

}

function isGameOver(char,board){
   //if 3 in a row.. stop horizontals
   for(var x=0;x<3;x++){
    if(board[x+0]+board[x+1]+board[x+2]==char) return true;
    }
    //if 3 in a row.. stop vericals
    for(var x=0;x<3;x++){
    if(board[x+0]+board[x+3]+ board[x+6]==char) return true;
    }

//diagonals

    if(board[x+0]+board[x+4]+board[8]==char)return true;
    if(board[x+2]+board[x+4]+board[6]==char)return true;

    return false;

}

module.exports = {prepare,play};