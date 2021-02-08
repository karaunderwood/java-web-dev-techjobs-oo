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

    //TODO: test that the ID values for the two objects are NOT the same and differ by 1
    @Test
    public void testSettingJobId() {
        assertEquals(1, test_Job1.getId(), .001);
        assertEquals(2, test_Job2.getId(), .001);
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
    }


}
