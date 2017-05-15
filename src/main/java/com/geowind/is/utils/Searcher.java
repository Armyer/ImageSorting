package com.geowind.is.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

import com.geowind.is.domain.Picture;

import net.semanticmetadata.lire.builders.DocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.features.GlobalFeature;
import net.semanticmetadata.lire.imageanalysis.features.global.CEDD;
import net.semanticmetadata.lire.searchers.GenericFastImageSearcher;
import net.semanticmetadata.lire.searchers.ImageSearchHits;
import net.semanticmetadata.lire.searchers.ImageSearcher;

public class Searcher {
	
	
	public List<Picture> searcherByPic(String path,String indexPath) throws IOException{
		
		 // Checking if arg[0] is there and if it is an image.
        BufferedImage img = null;
        boolean passed = false;
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists()) {
                try {
                    img = ImageIO.read(f);
                    passed = true;
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
        if (!passed) {
            System.out.println("No image given as first argument.");
            System.out.println("Run \"Searcher <query image>\" to search for <query image>.");
            System.exit(1);
            return null;
        }
        
        //System.out.println("path  swdw is "+Paths.get("index"));
        //IndexReader ir = DirectoryReader.open(FSDirectory.open(Paths.get("index")));
        
        IndexReader ir = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
        
        System.out.println("path is "+Paths.get("index"));
        ImageSearcher searcher = new GenericFastImageSearcher(30, (Class<? extends GlobalFeature>) CEDD.class);
        // ImageSearcher searcher = new GenericFastImageSearcher(30, AutoColorCorrelogram.class); // for another image descriptor ...

        /*
            If you used DocValues while Indexing, use the following searcher:
         */
        // ImageSearcher searcher = new GenericDocValuesImageSearcher(30, CEDD.class, ir);

        // searching with a image file ...
        ImageSearchHits hits = searcher.search(img, ir);
        // searching with a Lucene document instance ...
        // ImageSearchHits hits = searcher.search(ir.document(0), ir);
        
        List<Picture> pictureList = new ArrayList<>();
        for (int i = 0; i < hits.length(); i++) {
            String fileName = ir.document(hits.documentID(i)).getValues(DocumentBuilder.FIELD_NAME_IDENTIFIER)[0];
            System.out.println(hits.score(i) + ": \t" + fileName);
            Picture picture = new Picture();
            picture.setLocation(fileName);
            String s = String.valueOf(hits.score(i));
            picture.setStatus(s);
            pictureList.add(picture);
        }
		ir.close();
		return pictureList;
		
	}
	
//	public static void main(String[] args) throws IOException {
//        // Checking if arg[0] is there and if it is an image.
//        BufferedImage img = null;
//        boolean passed = false;
//        if (args.length > 0) {
//            File f = new File(args[0]);
//            if (f.exists()) {
//                try {
//                    img = ImageIO.read(f);
//                    passed = true;
//                } catch (IOException e) {
//                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                }
//            }
//        }
//        if (!passed) {
//            System.out.println("No image given as first argument.");
//            System.out.println("Run \"Searcher <query image>\" to search for <query image>.");
//            System.exit(1);
//        }
//
//        IndexReader ir = DirectoryReader.open(FSDirectory.open(Paths.get("index")));
//        System.out.println("path is "+Paths.get("index"));
//        ImageSearcher searcher = new GenericFastImageSearcher(30, (Class<? extends GlobalFeature>) CEDD.class);
//        // ImageSearcher searcher = new GenericFastImageSearcher(30, AutoColorCorrelogram.class); // for another image descriptor ...
//
//        /*
//            If you used DocValues while Indexing, use the following searcher:
//         */
//        // ImageSearcher searcher = new GenericDocValuesImageSearcher(30, CEDD.class, ir);
//
//        // searching with a image file ...
//        ImageSearchHits hits = searcher.search(img, ir);
//        // searching with a Lucene document instance ...
//        // ImageSearchHits hits = searcher.search(ir.document(0), ir);
//        for (int i = 0; i < hits.length(); i++) {
//            String fileName = ir.document(hits.documentID(i)).getValues(DocumentBuilder.FIELD_NAME_IDENTIFIER)[0];
//            System.out.println(hits.score(i) + ": \t" + fileName);
//        }
//    }

}
