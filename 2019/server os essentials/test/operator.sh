#!/bin/bash --

#test
BOOL2=$(test 0 -eq 0)
echo $BOOL2
test 0 -eq 0 && echo true || echo false
[ $BOOL2 ] && echo true || echo false

#[ ]
echo ""
echo "#[ ]:"
BOOL=$([ 0 -eq 0 ])
echo $BOOL
[ 0 -eq 0 ] && echo true || echo false
[ $BOOL ] && echo true || echo false
