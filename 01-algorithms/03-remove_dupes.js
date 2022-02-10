//given an array, remove duplicate values from it. Do it in place (do not create a new array to do this with). If you're having difficulty, its okay to try an baby step it first by using a new array and making it work that way.


function removeDupes(arr){
    //you can use an object to keep track of values (hint)
    // create a for loop to go thru each index in an array
    //baby step the alog, see if you can print the index numbers
    //we are looping thru the array and can see that each value is logged
    //baby step, create object with unique values from array. check if each interation (value and index) if the object contains a key that is === to the current value in this iteration
    //save value to object as a key
    //baby step, see what the object is logged as
    //splice the array to cut out an index
    //run the code and log array
    //bug discovered if values are the same back got back
    //adding x-- after splicing fixes bug
    let obj = {};
    for (x=0; x<arr.length; x++){
        console.log(arr[x])
        if(obj[arr[x]]){ //x represents the index where the duplicate occurs, so we want to remove a value at index x from the array. 
            arr.splice(x,1);
            x--
        }else{ // save that value to the object
            obj[arr[x]] = true

        }
        
            
    }
    console.log(obj)
    console.log(arr)
}
    


console.log(removeDupes([3,6,7,3,2,7,7,9,9,9,9,0,1])) //output-> [3,6,7,2,9,0,1]

//
// x=0 => 1 => 2 => 3
// obj = {
//     "3":true,
//     "6":true,
//     "7":true,

// }

// baby step, create object with unique values from array
// {
//         "3":true,
//         "6":true,
//         "7":true,
//         "2":true,
//         "9":true,
//         "0":true,
//         "1":true
// }

function removeDupes(arr){
    for (var i = 0; i < arr.length; i++){
        var check = true
        for (var j = 0; j < arr.length; j++){
            if (arr[i] == arr[j] && check){
                check = false;
            }
            else if (arr[i] == arr[j] && check == false){
                arr.splice(j, 1);
            }
            else{
            }
        }
    }
    return arr;
}


const removeDupes = (arr) => {
    let arrObj = {};

    for(let i = 0; i < arr.length; i++){
        // if value at index i not in array object, then add it to array object with value of 1
        if (!(arr[i] in arrObj)){
            arrObj[arr[i]] = 1;
        }
        else if (arr[i] in arrObj){
            // otherwise , if value at index i is in array object, then remove it from array using splice.
            // splice takes in an index (i) and a number of elements to remove (only 1 in this case)
            arr.splice(i, 1)
            // because splice removes the value at index i and shifts the array, we need to decrement i
            // to avoid skipping any values
            i--;
        }
    }
}

arr = [3,6,7,3,2,7,7,9,0,1];
removeDupes(arr);
console.log(arr);


// let removeDupes = arr => newArr = [...new Set(arr)];


function removeDupes(arr){
    let dupObj = {[arr[0]]:true};

    for(let i=1; i<arr.length; i++){
     
        if(dupObj[arr[i]]){
            arr.splice(i,1);
            i--;
           
        }
        else{
            dupObj[arr[i]] = true;
        }
    }

}

let myArray = [3,6,7,3,2,7,7,9,0,1]

removeDupes(myArray);
console.log(myArray); //output-> [3,6,7,2,9,0,1]


function removeDupes(arr){
    for(let i = 0; i < arr.length; i++){
        for(let j = i + 1; j < arr.length; j++){
            if(arr[i] === arr[j]){
                arr.splice(j, 1);
                j--;
            }
        }
    }
    return arr;
}

console.log(removeDupes([3,6,7,3,2,7,7,9,0,1])); //output-> [3,6,7,2,9,0,1]



// //given an array, remove duplicate values from it. Do it in place (do not create a new array to do this with). If you're having difficulty, its okay to try an baby step it first by using a new array and making it work that way.


// function removeDupes(arr) {
//     //you can use an object to keep track of values (hint)

//     let dupValues = [];
//     for (let i = 0; i < arr.length; i++) {
//         // console.log(arr[i])
//         if (!dupValues.includes(arr[i])) {
//             dupValues.push(arr[i]);
//             // console.log(arr[i])
//         }
//     }
//     return dupValues;
// }

// console.log(removeDupes([3, 6, 7, 3, 2, 7, 7, 9, 0, 1])) //output-> [3,6,7,2,9,0,1]



function removeDupes2(arr) {
    //you can use an object to keep track of values (hint)

    let dupObj = {

    };
    let result = false;

    for (let i = 0; i < arr.length; i++) {
        // console.log(arr[i])
        if (dupObj[arr[i]]) { //if the key exists
            console.log(dupObj)
            arr.splice(i, 1)
            i--;
            // result = true;
            // break;
        } else { //if the key does not exist
            dupObj[arr[i]] = true

        }
        // console.log(dupObj)
    }
    if (result == false) {
        console.log("There are duplicate values")
    }
    return arr;

}
/*
{
    "3":true,
    "6":true,
    "7":true,


}



*/



console.log(removeDupes2([3, 6, 7, 3, 2, 7, 7, 7, 9, 0, 1, 3])) //output-> [3,6,7,2,9,0,1]



function removeDupes(arr){
    //you can use an object to keep track of values (hint)
    // let temp = []
    // for (i=0; i < arr.length; i++) {
    //     if (!temp.includes(arr[i])) {
    //         temp.push(arr[i]);
    //     }
    // }
    // return temp
    
    var result = [];
    
    arr.forEach(function(element) {
        
        if (result.indexOf(element) === -1) {
            result.push(element);
        }
    });
    
    return result;
    
}

console.log(removeDupes([3,6,7,3,2,7,7,9,0,1])) //output-> [3,6,7,2,9,0,1]