package com.techproed.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
//Set Language level to 7--

public class IsExistClass{

    @Test
    public void isExist(){
        //Check if the dom image is existing

        //Find the path of the image
        String pathOfTheFile = "C:\\Users\\atab\\Pictures\\dom.png";
        //We will use JAVA to check if a file exist or not.
        Boolean exist = Files.exists(Paths.get(pathOfTheFile));

        //Assert if the path exist
        Assert.assertTrue(exist);

    }
}
