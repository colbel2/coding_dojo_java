// Matrix Search
// Jenny digs image and wants to make a JavaScript imaging library like PIL for python. She is given 2 different two-dimensional arrays, containing integers between 0 and 65535. Each two dimensional array represents a grey-scale image, where each integer value is a pixel. The second image might be somewhere inside the larger one. Return whether it is.
// Given Array: [ [12, 34, 45, 56],    And Array: [ [67, 78],      return: true
//                [98, 87, 76, 65],                 [43, 32] ];   
//                [56, 67, 78, 89],
//                [54, 43, 32, 21] ];


let x = [
    [12, 34, 45, 56],
    [98, 87, 76, 65],
    [56, 67, 78, 89],
    [54, 43, 32, 21]
]

let y = [
    [67, 78],
    [43, 32]
]


let z = [
    [67, 77],
    [43, 32]
]


function matrixSearch(bigArr, smallArr){

    for (i=0; i< bigArr.length; i++){
        console.log(bigArr[i])
        for (j=0; j< bigArr[i].length; j++){
            console.log(bigArr[i][j])
        }
    }
    
}

console.log(matrixSearch(x,y)) //true
// console.log(matrixSearch(x,z)) //false




const matrixSearch = (bigArr, smallArr) => {
    let found = false
    let start = []
    for(let i=0;i<smallArr.length;i++){             //outerloop
        for(let j=0;j<smallArr[i].length;j++){      //innerloop
            let x = 0
            while(x<bigArr.length){
                for(let y=0;y<bigArr[x].length;y++){
                    if(smallArr[i][j]==bigArr[x][y] && found == false){
                        start = [x, y]
                        found = true
                        console.log(start)
                    }
                }
                x++
            }
        }
        for(let i=0;i<smallArr.length;i++){
            for(let j=0;j<smallArr[i].length;j++){
                if(smallArr[i][j] == bigArr[start[0]+i][start[1]+j]){
                    found == true
                }
                else return false
            }
        }
    }
    return found
}



function matrixSearch(matrix, pattern) {
    //Nested loop to iterate matrix
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            //Nested loop to iterate pattern
            let matches = true;
            for (let x = 0; x < pattern.length && matches; x++) {
                for (let y = 0; y < pattern[x].length && matches; y++) {
                    //Breaks loop when matches becomes false, or reaches end of pattern
                    matches = matrix[i + x][j + y] == pattern[x][y]
                }
            }
            //Returns true if entire pattern matched (reached end of loop without matches becoming false)
            if (matches) {
                return true;
            }
        }
    }
    //Return false if no match was found
    return false;
}


function matrixSearch(bigArr, smallArr){
    var startval = smallArr[0][0]
    var exist = false
    for(x=0; x < bigArr.length; x++){
        console.log(bigArr[x])
        for (i=0; i < bigArr[x].length; i++){
            console.log(bigArr[x][i])
            if(startval == bigArr[x][i]){ //when the startval (67) is found in big array. x and i represent the coordinates of the start value found in the big array
                exist = true
                for(j=0; j< smallArr.length; j++){
                    for(z=0; z < smallArr[j].length; z++){
                        console.log ("small array value: ", smallArr[j][z])
                        console.log("big array corresponding values", bigArr[x+j][i+z])
                        //if smallarray at it corresponding indeces does not equeal the big array at its corresponding indices, then set exists to be false
                        if(smallArr[j][z] != bigArr[x+j][i+z] ){
                            exist = false
                        }
                    }
                }  
            }
        }
    }
    return exist
}


//The value of a function call is whatever that function call returns.  
// console.log(matrixSearch(x,y)) //true
console.log(matrixSearch(x,z)) //false