package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Job;

import static org.junit.Assert.*;

public class JobTest {
    Job test_Job1;
    Job test_Job2;
    Job test_Job3;
    Job test_Job4;
    Job test_Job5;
    @Before
    public void createFirstJobObject() {
        test_Job1 = new Job();
    }

    @Before
    public void createSecondJobObject() {
        test_Job2 = new Job();
    }

    @Before
    public void createThirdJobObject() {
        test_Job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Before
    public void createFourthJobObject() {
        test_Job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Before
    public void createFifthJobObject() {
        test_Job5 = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
    }


    // Test that the ID values for the two objects are NOT the same and differ by 1
    @Test
    public void testSettingJobId() {
        assertEquals(1, test_Job2.getId() - test_Job1.getId());
    }

    // Test the full constructor
    @Test
    public void TestJobConstructorSetsAllFields() {
        assertTrue(test_Job3.getEmployer() instanceof Employer);
        assertTrue(test_Job3.getLocation() instanceof Location);
        assertTrue(test_Job3.getPositionType() instanceof PositionType);
        assertTrue(test_Job3.getCoreCompetency() instanceof CoreCompetency);
    }

    // Test the equals method
    @Test
    public void testJobsForEquality() {
        assertFalse(test_Job3.equals(test_Job4));
        assertTrue(test_Job4.equals(test_Job4));
    }


    // When passed a Job object, it should return a string that contains a blank line before and after the job information.
    @Test
    public void testJobsToReturnStringSurroundedByBlankLines(){
        int length = test_Job3.toString().length();

        assertSame(test_Job3.toString().charAt(0), '\n');
        assertSame(test_Job3.toString().charAt(length - 1), '\n');
    }


    // The string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.
    @Test
    public void TestJobsToStringToContainLabelsDataAndNewLines() {
        assertEquals(test_Job3.toString(),
                "\nID: " + test_Job3.getId() +
                        "\nName: " + test_Job3.getName() +
                        "\nEmployer: " + test_Job3.getEmployer() +
                        "\nLocation: " + test_Job3.getLocation() +
                        "\nPosition Type: " + test_Job3.getPositionType() +
                        "\nCore Competency: " + test_Job3.getCoreCompetency() +
                        "\n"
                );
    }


    // If a field is empty, the method should add, “Data not available” after the label.
    @Test
    public void testJobsWithNoData() {
        assertTrue(test_Job5.toString().contains("Data not available"));
    }

}
