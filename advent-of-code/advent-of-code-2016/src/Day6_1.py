col_1 = {};
col_2 = {};
col_3 = {};
col_4 = {};
col_5 = {};
col_6 = {};
col_7 = {};
col_8 = {};

storage = [col_1,col_2,col_3,col_4,col_5,col_6,col_7,col_8]
lines = [line.rstrip('\n') for line in open('/home/freddy/Input_Day6_1', 'r')]

for line in lines:
   for i, c in enumerate(line):
       if c in storage[i]:    
           storage[i][c] = storage[i][c] + 1 
       else:
           storage[i][c] = 1        

# Most common chars
for column in storage:
    maxVal = list(column.values())[0]
    commonChar = '' 
    for character, val in column.items():
        currentVal = val
        if currentVal >= maxVal:
            maxVal = currentVal
            commonChar = character

    print(commonChar)

print('---------------')    

# Less common chars
for column in storage:
    minVal = list(column.values())[0]
    lessCommonChar = '' 
    for character, val in column.items():
        currentVal = val
        if currentVal <= minVal:
            minVal = currentVal
            lessCommonChar = character          

    print(lessCommonChar)
    

