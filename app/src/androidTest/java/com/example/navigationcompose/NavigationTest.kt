package com.example.navigationcompose

import androidx.compose.ui.test.AndroidComposeUiTest
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class NavigationTest     {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_NavigateToUserScreen() {
        // 2. Start the app (or just your Navigation Host)
        composeTestRule.setContent {
            MainScreen() // Calling the nav function you created earlier
        }

        composeTestRule.waitUntil(5000) {
            composeTestRule.onAllNodesWithText("Home").fetchSemanticsNodes().isNotEmpty()
        }

        // 3. Find the button on the Main Screen and click it
        // We find it by the text it contains
        composeTestRule.onNodeWithText("Home").performClick()
        composeTestRule.onNodeWithText("Search").performClick()
        composeTestRule.onNodeWithText("Profile").performClick()

        // 4. Assertion: Check if the "Hello, User!" text is now visible
        // This proves we successfully navigated
        composeTestRule.onNodeWithText("Login").assertIsDisplayed()
    }

}