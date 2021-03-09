function [aSize] = aSize(img)
im = imread(img);
w = size(im)(1);
h = size(im)(2);

wc = 0;

for i = 1:1:w
    for j = 1:1:h
        r = im(i,j,1);
        g = im(i,j,2);
        b = im(i,j,3);
        
        if (r < 32) || (g < 32) || (b < 32)
          wc = wc + 1;
        end
    end
end

aSize = round(50.8 * 18 * wc / (w*h));