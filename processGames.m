pkg load image;

sz = aSize('camA.jpg')
clr = char(color('camA.jpg', "aEdge.jpg"))
shp = 'cube';

cmdStr = ['echo  ' clr ' ' shp ' ' char(sz)];

%system('ls');
system(cmdStr);
