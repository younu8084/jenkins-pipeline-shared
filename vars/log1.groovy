#!/bin/bash
def call(){ 
log=log_file.txt
 

printf "Log File - " > $log
 

date >> $log
 
x=$(( 3 + 1 ))

echo value of x is $x >> $log
}
