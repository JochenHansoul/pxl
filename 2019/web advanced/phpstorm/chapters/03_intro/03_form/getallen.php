<?php

$aantal = $_GET['aantal'];

if (ctype_digit($aantal) && (int) $aantal > 0) {
    ?>
    <form action="statistiek.php">
    <?php
         for($i = 0; $i < (int) $aantal; $i++) {
             echo "<input type='text' name='getallen[]'/>";
             echo "<br/>";
         }
    ?>
    <input type="submit"/>
    </form>
    <?php
} else {
    header("Location: ingave.html");
}
