package com.eriksuta.parser;


import com.eriksuta.data.Indexer;
import com.eriksuta.data.ParserImpl;
import com.eriksuta.data.SearchUtil;
import com.eriksuta.data.search.SearchResultType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import java.io.*;

/**
 *  @author shood
 * */
public class BasicTest {

    private static final String DIR = "src/test/resources/test/";

    private static final String F_TEST_01_BASIC_SEARCH_BRATISLAVA = DIR + "test_01_basicSearch_Bratislava.txt";
    private static final String F_TEST_02_BASIC_SEARCH_BIOWARE = DIR + "test_02_basicSearch_Bioware.txt";
    private static final String F_TEST_03_BASIC_SEARCH_MASS_EFFECT = DIR + "test_03_basicSearch_MassEffect.txt";
    private static final String F_TEST_04_BASIC_SEARCH_STAR_WARS = DIR + "test_04_basicSearch_StarWars.txt";

    @BeforeClass
    public static void beforeClass(){
        System.out.println("==========|BASIC PARSER TEST SUIT START|==========");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("==========|BASIC PARSER TEST SUIT END|==========");
    }

    /**
     *  Run this test to perform complete parsing process
     *  !!WARNING!! - may take long time
     * */
    @Test
    public void performParseProcess(){
        ParserImpl parser = new ParserImpl();
        parser.parseSlovakDBPedia();
    }

    /**
     *  Run this test to perform complete indexing process
     *  !!WARNING!! - may take long time
     * */
    @Test
    public void performIndexProcess(){
        Indexer indexer = new Indexer();
        indexer.performIndexing();
    }

    @Test
    public void testBratislava(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Bratislava");
        System.out.println(result.toString());
    }

    @Test
    public void testBioware(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Bioware");
        System.out.println(result.toString());
    }

    @Test
    public void testMassEffect(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Mass Effect");
        System.out.println(result.toString());
    }

    @Test
    public void testStarWars(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Star_Wars");
        System.out.println(result.toString());
    }

    @Test
    public void test_01_basicSearch_Bratislava(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Bratislava");

        String expectedResult = readFile(F_TEST_01_BASIC_SEARCH_BRATISLAVA);

        Assert.assertEquals(result.toStringWithoutTime().trim(), expectedResult.trim());
    }

    @Test
     public void test_02_basicSearch_Bioware(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Bioware");

        String expectedResult = readFile(F_TEST_02_BASIC_SEARCH_BIOWARE);

        Assert.assertEquals(result.toStringWithoutTime().trim(), expectedResult.trim());
    }

    @Test
    public void test_03_basicSearch_MassEffect(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Mass Effect");

        String expectedResult = readFile(F_TEST_03_BASIC_SEARCH_MASS_EFFECT);

        Assert.assertEquals(result.toStringWithoutTime().trim(), expectedResult.trim());
    }

    @Test
    public void test_04_basicSearch_StarWars(){
        SearchUtil searchUtil = new SearchUtil();
        SearchResultType result = searchUtil.basicSearch("Star_Wars");

        String expectedResult = readFile(F_TEST_04_BASIC_SEARCH_STAR_WARS);

        Assert.assertEquals(result.toStringWithoutTime().trim(), expectedResult.trim());
    }

    private String readFile(String file) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;

            String ls = System.getProperty("line.separator");

            while((line = reader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}