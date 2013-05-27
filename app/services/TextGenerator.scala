package services

/**
 * A type declaring the interface that will be injectable.
 */
class TextGenerator(val welcomeText: String)

/**
 * A simple implementation of TextGenerator that we will inject.
 */
class WelcomeTextGenerator extends TextGenerator("Your new application is ready.")