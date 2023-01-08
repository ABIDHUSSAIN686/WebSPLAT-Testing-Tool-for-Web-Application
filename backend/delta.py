import sys
from difflib import HtmlDiff
 
def getDataFromJava(arg1,arg2):
    arg1_val=arg1
    arg2_val=arg2
    print(arg1_val)
    print(arg2_val)
    file1 = open("Version1/"+arg1_val, 'r').readlines()
    file2 = open("Version2/"+arg2_val, 'r').readlines()
    d = HtmlDiff()
    difference = d.make_file(file1, file2)
    with open("J:/7 semester/FYP/frontend/public/Comparision/"+arg1_val, "w") as f:
        for line in difference.splitlines():
            print (line, file=f)
    
    return arg1_val,arg2_val
    
    
    
arg1 = sys.argv[1]
arg2 = sys.argv[2]

getDataFromJava(arg1,arg2)