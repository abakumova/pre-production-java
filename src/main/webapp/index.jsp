<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="CalculatorServlet" method="get" name="frm">
    Enter num1:
    <input name="txt1" type="text" />
    Enter num2:
    <input name="txt2" type="text" />
    Operator
    <select name="op">
        <option value="Addition">Addition</option>
        <option value="Subtraction">Subtraction</option>
        <option value="Multiplication">Multiplication</option>
        <option value="Division">Division</option>
    </select>
    <input type="submit" value="submit" />
</form>
</body>
</html>