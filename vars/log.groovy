#!/bin/bash
def call()
{
LOGFILE=/home/test/test.log
echo "`date +%H:%M:%S : Starting work" >> $LOGFILE

service test stop >> $LOGFILE

mv /var/run/test/test.pid /var/run/test/test.pid.bak

echo "`date +%H:%M:%S : process file moved" >> $LOGFILE

service test start >> $LOGFILE

echo "`date +%H:%M:%S : Finished" >> $LOGFILE
}
