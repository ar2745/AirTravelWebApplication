// Andrew Robinson
// 2024-08-24
// IT-634
// Module Four Milestone One - Test Flight Search Form
// The following code is an automated test for the flight search form on the travel website. 

// Test for Flight Search Form

// Function to simulate form submission
function simulateFormSubmission() {
    // Create a new event for form submission
    const event = new Event('submit', {
        bubbles: true,
        cancelable: true,
    });

    // Get the form element
    const form = document.getElementById('flightSearchForm');

    // Fill in the form fields with test data
    document.getElementById('startLocation').value = 'New York';
    document.getElementById('endLocation').value = 'Miami';
    document.getElementById('travelDate').value = '2024-08-24';
    document.getElementById('numTravelers').value = 2;

    // Dispatch the form submission event
    form.dispatchEvent(event);
}

// Function to run the tests
function runTests() {
    // Simulate form submission
    simulateFormSubmission();

    // Check the results
    const resultsDiv = document.getElementById('results');
    const expectedText = 'Searching for flights from New York to Los Angeles on 2024-12-25 for 2 travelers...';

    if (resultsDiv.innerHTML.includes(expectedText)) {
        console.log('Test Passed: Form submission works correctly.');
    } else {
        console.log('Test Failed: Form submission did not produce the expected results.');
    }
}

// Run the tests after the DOM is fully loaded
document.addEventListener('DOMContentLoaded', runTests);