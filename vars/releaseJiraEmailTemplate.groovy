class releaseJiraEmailTemplate implements Serializable {
	def getReleaseNotesTemplate(){
		def jiraReleaseNotesTemplateString = 
		StringEscapeUtils.escapeHtml("${<html>
		   <head>
			  <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=us-ascii">
			  <meta name=Generator content="Microsoft Word 15 (filtered medium)">
			  <!--[if !mso]>
			  <style>v\:* {behavior:url(#default#VML);}
				 o\:* {behavior:url(#default#VML);}
				 w\:* {behavior:url(#default#VML);}
				 .shape {behavior:url(#default#VML);}
			  </style>
			  <![endif]-->
			  <style>
				 <!--
					/* Font Definitions */
					@font-face
            			{font-family:"Cambria Math";
            			panose-1:2 4 5 3 5 4 6 3 2 4;}
					@font-face
            			{font-family:Calibri;
            			panose-1:2 15 5 2 2 2 4 3 2 4;}
					/* Style Definitions */
					p.MsoNormal, li.MsoNormal, div.MsoNormal
            			{margin:0cm;
            			margin-bottom:.0001pt;
            			font-size:11.0pt;
            			font-family:"Calibri",sans-serif;
            			mso-fareast-language:EN-US;}
					a:link, span.MsoHyperlink
            			{mso-style-priority:99;
            			color:#0563C1;
            			text-decoration:underline;}
					a:visited, span.MsoHyperlinkFollowed
            			{mso-style-priority:99;
            			color:#954F72;
            			text-decoration:underline;}
					span.EmailStyle17
            			{mso-style-type:personal-compose;
            			font-family:"Calibri",sans-serif;
            			color:windowtext;}
					.MsoChpDefault
            			{mso-style-type:export-only;
            			font-family:"Calibri",sans-serif;
            			mso-fareast-language:EN-US;}
					@page WordSection1
            			{size:612.0pt 792.0pt;
            			margin:72.0pt 72.0pt 72.0pt 72.0pt;}
					div.WordSection1
            			{page:WordSection1;}
					-->
			  </style>
			  <!--[if gte mso 9]>
			  <xml>
				 <o:shapedefaults v:ext="edit" spidmax="1026" />
			  </xml>
			  <![endif]--><!--[if gte mso 9]>
			  <xml>
				 <o:shapelayout v:ext="edit">
					<o:idmap v:ext="edit" data="1" />
				 </o:shapelayout>
			  </xml>
			  <![endif]-->
		   </head>
		   <body lang=EN-IE link="#0563C1" vlink="#954F72">
			  <div class=WordSection1>
				 <p class=MsoNormal>
					Hi Tim,
					<o:p></o:p>
				 </p>
				 <p class=MsoNormal>
					<o:p>&nbsp;</o:p>
				 </p>
				 <p class=MsoNormal>
					Tomorrow can you retest the following shipped with today&#8217;s release in the new environment and progress accordingly?
					<o:p></o:p>
				 </p>
				 <p class=MsoNormal>
					<o:p>&nbsp;</o:p>
				 </p>
				 <table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0 width=0 style='width:453.35pt;border-collapse:collapse;border:none'>
					<thead>
					   <tr style='height:30.0pt'>
						  <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;background:#00B0F0;padding:0cm 5.4pt 0cm 5.4pt;height:30.0pt'>
							 <p class=MsoNormal>
								<b>
								   <span style='font-size:10.0pt;color:white;mso-fareast-language:EN-IE'>
									  Issue Type
									  <o:p></o:p>
								   </span>
								</b>
							 </p>
						  </td>
						  <td width=95 valign=top style='width:71.0pt;border:solid #00B0F0 1.0pt;border-left:none;background:#00B0F0;padding:0cm 5.4pt 0cm 5.4pt;height:30.0pt'>
							 <p class=MsoNormal>
								<b>
								   <span style='font-size:10.0pt;color:white;mso-fareast-language:EN-IE'>
									  Key
									  <o:p></o:p>
								   </span>
								</b>
							 </p>
						  </td>
						  <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-left:none;background:#00B0F0;padding:0cm 5.4pt 0cm 5.4pt;height:30.0pt'>
							 <p class=MsoNormal>
								<b>
								   <span style='font-size:10.0pt;color:white;mso-fareast-language:EN-IE'>
									  Severity
									  <o:p></o:p>
								   </span>
								</b>
							 </p>
						  </td>
						  <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-left:none;background:#00B0F0;padding:0cm 5.4pt 0cm 5.4pt;height:30.0pt'>
							 <p class=MsoNormal>
								<b>
								   <span style='font-size:10.0pt;color:white;mso-fareast-language:EN-IE'>
									  Priority
									  <o:p></o:p>
								   </span>
								</b>
							 </p>
						  </td>
						  <td width=233 valign=top style='width:174.6pt;border:solid #00B0F0 1.0pt;border-left:none;background:#00B0F0;padding:0cm 5.4pt 0cm 5.4pt;height:30.0pt'>
							 <p class=MsoNormal>
								<b>
								   <span style='font-size:10.0pt;color:white;mso-fareast-language:EN-IE'>
									  Summary
									  <o:p></o:p>
								   </span>
								</b>
							 </p>
						  </td>
						  <td width=85 valign=top style='width:63.75pt;border:solid #00B0F0 1.0pt;border-left:none;background:#00B0F0;padding:0cm 5.4pt 0cm 5.4pt;height:30.0pt'>
							 <p class=MsoNormal>
								<b>
								   <span style='font-size:10.0pt;color:white;mso-fareast-language:EN-IE'>
									  Status
									  <o:p></o:p>
								   </span>
								</b>
							 </p>
						  </td>
					   </tr>
					</thead>
					<tr style='height:28.5pt'>
					   <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Bug
								<span style='color:black'>
								   <o:p></o:p>
								</span>
							 </span>
						  </p>
					   </td>
					   <td width=95 valign=top style='width:71.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								<a href="https://exaxejira.atlassian.net/browse/ALEUAT-1527">ALEUAT-1527</a>
								<u>
								   <o:p></o:p>
								</u>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Critical
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								3 - Medium
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=233 valign=top style='width:174.6pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Scenario 36 - Pension Comparison quote issues
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=85 valign=top style='width:63.75pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Resolved
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					</tr>
					<tr style='height:28.5pt'>
					   <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Bug
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=95 valign=top style='width:71.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								<a href="https://exaxejira.atlassian.net/browse/ALEUAT-2080">ALEUAT-2080</a>
								<u>
								   <o:p></o:p>
								</u>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Major
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								2 - High
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=233 valign=top style='width:174.6pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Issue with Image taken at the DDM signature point
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=85 valign=top style='width:63.75pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Resolved
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					</tr>
					<tr style='height:28.5pt'>
					   <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Bug
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=95 valign=top style='width:71.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								<a href="https://exaxejira.atlassian.net/browse/ALEUAT-2101">ALEUAT-2101</a>
								<u>
								   <o:p></o:p>
								</u>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Major
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								3 - Medium
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=233 valign=top style='width:174.6pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								27.20 FL EApp Supporting Docs Issues with Other Field
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=85 valign=top style='width:63.75pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Resolved
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					</tr>
					<tr style='height:28.5pt'>
					   <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Bug
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=95 valign=top style='width:71.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								<a href="https://exaxejira.atlassian.net/browse/ALEUAT-2109">ALEUAT-2109</a>
								<u>
								   <o:p></o:p>
								</u>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Critical
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								3 - Medium
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=233 valign=top style='width:174.6pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Issues with Oral Explanations - see attachment
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=85 valign=top style='width:63.75pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Resolved
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					</tr>
					<tr style='height:28.5pt'>
					   <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Bug
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=95 valign=top style='width:71.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								<a href="https://exaxejira.atlassian.net/browse/ALEUAT-2139">ALEUAT-2139</a>
								<u>
								   <o:p></o:p>
								</u>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Critical
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								3 - Medium
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=233 valign=top style='width:174.6pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								DIC &amp; DOC factors in quote engine
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=85 valign=top style='width:63.75pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.5pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Resolved
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					</tr>
					<tr style='height:44.4pt'>
					   <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:44.4pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Bug
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=95 valign=top style='width:71.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:44.4pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								<a href="https://exaxejira.atlassian.net/browse/ALEUAT-2150">ALEUAT-2150</a>
								<u>
								   <o:p></o:p>
								</u>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:44.4pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Critical
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:44.4pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								3 - Medium
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=233 valign=top style='width:174.6pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:44.4pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Pilot Version - Offline 'Head Office' emails are not being sent for some products (Blocker)
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=85 valign=top style='width:63.75pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:44.4pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Resolved
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					</tr>
					<tr style='height:28.9pt'>
					   <td width=64 valign=top style='width:48.0pt;border:solid #00B0F0 1.0pt;border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:28.9pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Bug
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=95 valign=top style='width:71.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.9pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								<a href="https://exaxejira.atlassian.net/browse/ALEUAT-2160">ALEUAT-2160</a>
								<u>
								   <o:p></o:p>
								</u>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.9pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Critical
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=64 valign=top style='width:48.0pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.9pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								3 - Medium
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=233 valign=top style='width:174.6pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.9pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								BMI Rating Tables Update
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					   <td width=85 valign=top style='width:63.75pt;border-top:none;border-left:none;border-bottom:solid #00B0F0 1.0pt;border-right:solid #00B0F0 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:28.9pt'>
						  <p class=MsoNormal>
							 <span style='font-size:10.0pt;mso-fareast-language:EN-IE'>
								Resolved
								<o:p></o:p>
							 </span>
						  </p>
					   </td>
					</tr>
				 </table>
			  </div>
		   </body>
		</html>}");

		jiraReleaseNotesTemplateString
	}
}

