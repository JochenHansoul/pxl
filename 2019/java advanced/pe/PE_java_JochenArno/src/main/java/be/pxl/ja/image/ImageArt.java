package be.pxl.ja.image;

import be.pxl.ja.common.DistanceUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImageArt {

    public static void main(String[] args) throws IOException {

        RGBPixel prussianBlue = new RGBPixel(0, 48, 80);
        RGBPixel desaturatedCyan = new RGBPixel(112, 150, 160);
        RGBPixel peachYellow = new RGBPixel(250, 227, 173);
        RGBPixel lava = new RGBPixel(218, 20, 21);
        List<RGBPixel> faireyColors = Arrays.asList(prussianBlue, lava, desaturatedCyan, peachYellow);

        List<List<RGBPixel>> imageList = ImageReader.readImage(Paths.get("src/main/resources/tokio.jpg"));

        //Vraag 4a: Grayscale image
        List<List<GrayscalePixel>> greyscaleImage = new LinkedList<>();
        for (List<RGBPixel> rowImage : imageList) {
            List<GrayscalePixel> convertedRow = rowImage.stream() //creates a stream, convert all RGBpixels to GrayscalePixels en converts stream to a list
                    .map(RGBPixel::convertToGreyscale)
                    .collect(Collectors.toList());
            greyscaleImage.add(convertedRow);
        }
        ImageWriter.writeImage(Paths.get("src/main/resources/greyscale.jpg"), greyscaleImage); //to store greyscale.jpg image

        //vraag 4b: Fairey-cize
        List<List<RGBPixel>> faireyImage = new LinkedList<>();

        TreeSet<GrayscalePixel> grayscaleTreeAllPixels = new TreeSet<>();
        for (List<GrayscalePixel> rowList : greyscaleImage) {
            grayscaleTreeAllPixels.addAll(rowList);
        }
        Map<GrayscalePixel, RGBPixel> grayscaleToFaireyColorsMapAllPixels = createTranslationMap(faireyColors, grayscaleTreeAllPixels);
        Set<GrayscalePixel> key = grayscaleToFaireyColorsMapAllPixels.keySet();

        for (List<GrayscalePixel> rowList : greyscaleImage) {
            //TreeSet<GrayscalePixel> grayscaleTree = new TreeSet<>(rowList); //sorter and orginised list of unique grayscalepixles
            //Map<GrayscalePixel, RGBPixel> grayscaleToFaireyColorsMap = createTranslationMap(faireyColors, grayscaleTree);
            List<RGBPixel> newRow = rowList.stream() //adding the new Fairey RGBPixels to a list
                    //.map(grayscalePixel -> grayscalePixel.closestGrayscalePixelTo(grayscaleToFaireyColorsMap.keySet()))
                    .map(grayscalePixel -> DistanceUtil.findClosest(key, grayscalePixel))
                    .map(grayscaleToFaireyColorsMapAllPixels::get)
                    .collect(Collectors.toList());
            faireyImage.add(newRow);
        }
        ImageWriter.writeImage(Paths.get("src/main/resources/faireyimageTokiosAll.jpg"), faireyImage);
    }

    private static Map<GrayscalePixel, RGBPixel> createTranslationMap(List<RGBPixel> faireyColors, TreeSet<GrayscalePixel> allGreyscalePixels) {
        int size = allGreyscalePixels.size() / faireyColors.size();

        Map<GrayscalePixel, RGBPixel> translationMap = new HashMap<>();
        Iterator<GrayscalePixel> iterator = allGreyscalePixels.iterator();
        // creates preferedlist with startindexes for faireyColors
        int startIndex = size / 2;
        List<Integer> preferedIndeces = new ArrayList<>();
        for (int group = 0; group < faireyColors.size(); group++) {
            preferedIndeces.add(startIndex);
            startIndex += size;
        }
        int index = 0;
        while (iterator.hasNext()) {
            GrayscalePixel grayscalePixel = iterator.next();
            if (preferedIndeces.contains(index)) {
                int position = preferedIndeces.indexOf(index);
                translationMap.put(grayscalePixel, faireyColors.get(position));
            }
            index++;
        }
        return translationMap;
    }

    /*private static Map<GrayscalePixel, GrayscalePixel> createGrayMap(List<GrayscalePixel> grayFaireyColors, TreeSet<GrayscalePixel> allGrayscalePixels) {
        //System.out.println("create nuw map:");
        Map<GrayscalePixel, GrayscalePixel> grayscalenMap = new HashMap<>(); //allgrayscale, 4 grayscale
        Iterator<GrayscalePixel> iterator = allGrayscalePixels.iterator();
        while (iterator.hasNext()) {
            GrayscalePixel treePixel = iterator.next();
            GrayscalePixel shortestPixel = grayFaireyColors.get(0);
            double shortestDistance = allGrayscalePixels.first().distance(grayFaireyColors.get(0));
            for (GrayscalePixel grayFaireyPixel : grayFaireyColors) {
                double distance = treePixel.distance(grayFaireyPixel);
                if (distance < shortestDistance) {
                    shortestPixel = grayFaireyPixel;
                    shortestDistance = distance;
                }
            }
            //System.out.println(treePixel + " --> " + shortestPixel);
            grayscalenMap.put(treePixel, shortestPixel);
        }
        //System.out.printf("\n\n\n");
        return grayscalenMap;
    }*/
}
