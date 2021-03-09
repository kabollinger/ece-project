# Read a 512x512 RGB image. 
# Resulting matrix size is [512  512  3]
im = imread('Redd.jpg');

%red = im(:,:,1);
%grn = im(:,:,2);
%blu = im(:,:,3);

for i = 1:1:size(im)(1)
    for j = 1:1:size(im)(2)
        r = im(i,j,1)
        g = im(i,j,2)
        b = im(i,j,3)
    end
end
