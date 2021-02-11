<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>form submission project</title>
    <link rel="stylesheet" href="css/style.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Abel&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <div class="wrapper">
      <form action="/process" method="post">
      
        <div class="nameline">
          <p>Your Name:</p>

          <input type="text" name="name" required />
        </div>

        <div class="locationline">
          <label for="location">Dojo Location:</label>
          <select id="location" name="location" required>
            <option value="Bellevue">Bellevue</option>
            <option value="LosAngeles">Los Angeles</option>
            <option value="SiliconValley">Silicon Valley</option>
          </select>
        </div>

        <div class="languageline">
          <label for="language">Favorite Language:</label>
          <select id="language" name="language" required>
            <option value="Python">Python</option>
            <option value="Javascript">Javascript</option>
            <option value="C">C</option>
          </select>
        </div>

        <p>Comment:</p>

        <textarea name="message" rows="10" cols="30" required></textarea>

        <input type="submit" class="submit" />
      </form>
    </div>
  </body>
</html>