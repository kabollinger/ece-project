function [aColor] = color(img, aedge)

edge=imread(aedge);
im = imread(img);
w = size(im)(1);
h = size(im)(2);

found = false;

for i = 1:1:w
    for j = 1:1:h
        r = im(i,j,1);
        g = im(i,j,2);
        b = im(i,j,3);
        
        if (r < 235) || (g < 235) || (b < 235)
          %r = im(i+5,j+5,1);
          %g = im(i+5,j+5,2);
          %b = im(i+5,j+5,3);
          arr = [r g b]; 

          if (r > 200) && (g < 32) && (b < 32)
                aColor = "red";
                found = true;
                break
            end
            if (r < 32) && (g < 32) && (b > 235)
                aColor = "blue";
                found = true;
                break
            end
            if (r > 128) && (g > 128) && (b < 32)
                aColor = "yellow";
                found = true;
                break
            end
            if (r > 235) && (g > 235) && (b > 235)
                aColor = "black";
                found = true;
                break
            end
        end

    end
end
if (found == false)
  aColor = "error"
end