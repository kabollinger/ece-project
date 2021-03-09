#!/bin/bash
rm *.jpg
clear
echo Taking Pictures
fswebcam -q --no-banner -r 432x240 -d /dev/video0 camA.jpg
echo A taken
fswebcam -q --no-banner -r 432x240 -d /dev/video1 camB.jpg
echo Done
