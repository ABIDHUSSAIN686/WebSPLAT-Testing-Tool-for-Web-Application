from difflib import Differ
import sys

def getDataFromJava(arg1,arg2):
    arg1_val=arg1
    arg2_val=arg2
    print(arg1_val)
    print(arg2_val)
    with open ("Version1/"+arg1_val) as f:
        file1_lines = f.readlines()
        with open ("Version1/"+arg2_val) as f:
            file2_lines = f.readlines()
            d = Differ()
            difference = list(d.compare(file1_lines, file2_lines))
            difference = '\n'.join(difference)
            # print (difference)
            with open("J:/7 semester/FYP/frontend/public/Changes/"+arg1_val, 'w') as outfile:
                outfile.write(difference)
    
    
arg1 = sys.argv[1]
arg2 = sys.argv[2]

getDataFromJava(arg1,arg2)