let x = [2,4,5,7,8,12,22,24,27,45,55,56,58,66,67,68,90,100, 222];
let y = [2,4,5,7,8,12,22,24,27,45,55,56,58,66,67,68,90,100, 222,333,334,335,678,700,8000,900000];



//create  a function that accepts an array and a value to search for. It will return true if value is found in input array. False if it isnt. Use binary search strategy
function binarySearch(arr, value){
    //print out middle index 
    // console.log (Math.floor(arr.length/2))

    var start = 0
    var end = arr.length

    while(start<end){
        var middle = Math.floor((start+end)/2)
        console.log({start,end, middle})
        console.log(arr[middle])
        //if the value we are looking for is equal to the value in the middle, return true
        if(value == arr[middle]){
            return true 
        }
        //otherwise if the value we are looking for is greater than the value in the middle
        else if(value>arr[middle]){
            start = middle + 1 
        }else{ //else means the value is less than the middle
            end= middle-1
        }
        
    }

    return false
    
    //pick a point in the middle of array and compare the value to find with the value in middle
    //if the value to find is greater than the value in middle, we know to look to the right of the middle point
    //repeat this process until the value is found or until the array has been fully looked through

}


console.log(binarySearch(x, 68)); //true
console.log(binarySearch(x, 51)); //false


const binarySearch = (arr, value, start = 0, end = arr.length-1) => {
    let mid = Math.floor((start+end)/2)
    if(value == arr[mid]) return true
    if(start==end && value != arr[mid]) return false
    if(value < arr[mid]) return binarySearch(arr, value, start, mid-1)
    if(value > arr[mid]) return binarySearch(arr, value, mid+1, end)
}


function binarySearch(arr,value,strpt=0,endpt=arr.length-1){

//taking notes on this algorithm so that i can finally learn something valuable with it in this class

    if(strpt>=endpt){
        if(value==arr[strpt]){
            return true;
        }else{
            return false;
        }
    }

    let valCheckPt= Math.floor((endpt + strpt)/2);


    if(arr[valCheckPt]==value){
        return true;
    }else if(arr[valCheckPt]>value){
        return binarySearch(arr,value,strpt,valCheckPt-1);
    }else{
        return binarySearch(arr,value,valCheckPt+1,endpt);
    }

}

let x = [2,4,5,7,8,12,22,24,27,45,55,56,58,66,67,68,90,100];

console.log(binarySearch(x, 68)); //true
console.log(binarySearch(x, 51)); //false


function binarySearch(arr, value){
    //pick a point in the middle of the array
    // 
    middle = Math.floor(arr.length/2)
    if(arr.length <= 1){
        return "Not in array"
    }
    
    else if (arr[middle] == value){
        return "Found it!"
    }

    else if (value > arr[middle]){
        NewArr = [];
        for (i = middle; i < arr.length; i++){
            NewArr.push(arr[i]);
        }
        return binarySearch(NewArr, value)
    }
    else if (value < arr[middle]){
        NewArr = [];
        for (i = 0; i < arr.length/2; i++){
            NewArr.push(arr[i]);
        }
        return binarySearch(NewArr, value)
    }
}


let x = [2,4,5,7,8,12,22,24,27,45,55,56,58,66,67,68,90,100];

function binarySearch(arr,target,start,end) {

    let middle = Math.floor((start+end)/2);

    if (arr[middle]===target) {
        return true;
    }
    if (start===end && arr[middle] != target) {
        return false;
    }
    if (arr[middle]>target) {
        return binarySearch(arr,target,start,middle-1)
    }
    if (arr[middle]<target) {
        return binarySearch(arr,target,middle+1,end)
    }
}
console.log(binarySearch(x,12,0,x.length-1)) // true
console.log(binarySearch(x,50,0,x.length-1)) // false


const binarySearch = (arr, value) => {
    //declare the start and end of our array
    let start = 0;
    let end = arr.length;
    //a while loop with the condition that our start never goes over our end
    while(start <= end) {
        //declare the midpoint of the array each go thru the loop
        const midPoint = Math.floor( (start + end) / 2 );
        //if by the grace of mt dew baja blast its in the middle
        if(arr[midPoint] === value) return midPoint;
        //if our mid value is less disregard the left half of the array and continue
        //searching on the right half  [ x, x, x, x, x, mid, ✓, ✓ ,✓, ✓, ✓ ]
        //                                                   ^---will be our new start
        else if(arr[midPoint] < value) start = midPoint + 1;       
        //if our mid value is greater disregard the right half of the array and continue
        //searching on the left half  [ ✓, ✓, ✓, ✓, ✓, mid, x, x ,x, x, x ]
        //                                             ^---will be our new end
        else end = midPoint - 1;        
    }
    //value was not found
    return false;
}
let x = [2,4,5,7,8,12,22,24,27,45,55,56,58,66,67,68,90,100];
console.log(binarySearch(x, 68)); //true
console.log(binarySearch(x, 51)); //false


function binarySearch(arr, value) {
    let middle = Math.floor(arr.length / 2);

    if (arr.length === 1 && arr[0] != value) {
        return false;
    }
    else if (arr[middle] == value) {
        return true;
    }
    else if (value > arr[middle]) {
        return binarySearch(arr.slice(middle), value)
    }
    else if (value < arr[middle]) {
        return binarySearch(arr.slice(0, middle), value)
    }
}