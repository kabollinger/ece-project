pkg load image
clear; clc; close all;

i = imread('camA.jpg');
I = rgb2gray(i);
BW1 = edge(I,'prewitt');
BI1 = imfill(BW1, 'holes');
imwrite(BW1, 'aEdge.jpg');


i2 = imread('camB.jpg');
I2 = rgb2gray(i2);
BW2 = edge(I2,'prewitt');
BI2 = imfill(BW2, 'holes');
imwrite(BW2, 'bEdge.jpg');

