#!/bin/bash --

BOOL=$([ 0 -eq 0 ])
echo $BOOL
[ 0 -eq 0 ] && echo true || echo false
[ $BOOL ] && echo true || echo false
