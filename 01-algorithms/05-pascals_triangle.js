function generate(numRows) {
    //     To build out this triangle, we need to take note of a few things.
        // Each row starts and ends with a 1.
        // Inside each row, between the 1s, each digit is the sum of the two digits immediately above it.
        // We can use this pattern to build new rows starting with row 3. But we can’t use it to build the first or second rows.
        // Each row is represented as an array; we need to output the entire triangle as an array of these rows (ie an array of arrays).
        
        
    };
    
    
    generate(5) //[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

    function generate(numRows) {

        if (numRows == 1) {
            return [[1]];
        }
        // Initialize first two rows, since they will always be the same
        let result = [[1], [1, 1]];
    
        for (let i = 2; i < numRows; i++) {
            let newRow = [];
            for (let j = 0; j <= i; j++) {
                // The first or last value of the row will always be 1
                if (j == 0 || j == i) {
                    newRow.push(1);
                }
                else {
                    // Otherwise add together sums of previous row and push to new row
                    let aboveNumSum = result[i - 1][j - 1] + result[i - 1][j];
                    newRow.push(aboveNumSum);
                }
            }
            result.push(newRow);
        }
        return result;
    };

    function generate(numRows){
        //Validation
        if (numRows <= 0) return [];
    
        //Create triangle with first row
        let triangle = [[1]];
    
        //Loop to generate correct # of rows
        for(let i = 1; i < numRows; i++){
            let newRow = [1]
            //Loop sums previous row to generate new row
            for(let j = 1; j < i; j++){
                newRow.push(triangle[i-1][j-1] + triangle[i-1][j]);
            }
            newRow.push(1);
            triangle.push(newRow);
        }
    
        return triangle;
    }

    const pascalsTriangle = num => {
        let arr = []
        let temp = [1]
        for(let i=0;i<num;i++){
            if(i==0){
                arr.push(temp)
                temp = [1]
            }
            else {
                for(j=1;j<=i;j++){
                    if(j==i){
                        temp.push(1)
                        arr.push(temp)
                        temp = [1]
                        
                    }
                    else{
                        let sum = arr[i-1][j-1] + arr[i-1][j]
                        temp.push(sum)
                    }
                }
            }
        }
        return arr
    }



    function generate(numRows) {
        //     To build out this triangle, we need to take note of a few things.
            // Each row starts and ends with a 1.
            // Inside each row, between the 1s, each digit is the sum of the two digits immediately above it.
            // We can use this pattern to build new rows starting with row 3. But we can’t use it to build the first or second rows.
            // Each row is represented as an array; we need to output the entire triangle as an array of these rows (ie an array of arrays).
            let triangle = [[1], [1,1]];
    
            //we know immediately when creating a new row that it will start with one
            //[]
            //in order to create the next row, we need to know the previous row
            //in order to know whats in the previous row-->we need to find the row at the last index of the triangle
    
            for(let j = 3; j<=numRows; j++){
                let prevRow = triangle[triangle.length-1]
                //to find what the previous row is
                let newrow = [1];
        
                //loop through the previous row
                for(let i = 0; i<prevRow.length-1; i++){
                    // console.log(prevRow[i])
                    let currentval = prevRow[i]
                    let nextVal = prevRow[i+1]
                    let sum = currentval + nextVal;
                    newrow.push(sum)
                }
                newrow.push(1)
    
                //after new row is generated, insert into triangle
                triangle.push(newrow)
                console.log("new row is this--->", newrow)
    
            }
    
            console.log(triangle)
    
        };
    
    generate(6)