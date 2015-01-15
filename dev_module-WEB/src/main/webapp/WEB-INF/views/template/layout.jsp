<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="header" />
</head>
<body background="#428bca">
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />

	<script type="text/javascript">
		$('.ui.dropdown').dropdown();
	</script>
</body>
</html>