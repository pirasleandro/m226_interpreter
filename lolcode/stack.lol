HAI 1.3 BTW VERSION
O HAI IM pile BTW BUCKIT DECLARATION
	I HAS A length ITZ 0 BTW VARIABLE_DECLARATION {name:length, value:0}
	I HAS A max ITZ -1 BTW VARIABLE_DECLARATION: {name:max, value:-1}
	
	HOW IZ I pushin YR item BTW FUNCITON_DECLARATION: {name:pushin, return_type:item}
		DIFFRINT ME'Z max AN BIGGR OF ME'Z max AN ME'Z length, O RLY? BTW IF_STATEMENT {EQUALS {first:max, second:BIGGER_OF {first:max, second:length}}}
			YA RLY, ME HAS A SRS ME'Z length ITZ item, ME'Z max R SUM OF ME'Z max AN 1
			NO WAI, ME'Z SRS ME'Z length R item
		OIC
		ME'Z length R SUM OF ME'Z length AN 1
	IF U SAY SO
	
	HOW IZ I popin
		DIFFRINT ME'Z length AN 0, O RLY?
		YA RLY
			ME'Z length R DIFF OF ME'Z length AN 1
			I HAS A item ITZ ME'Z SRS ME'Z length
			ME'Z SRS ME'Z length R NOOB
			FOUND YR item
		OIC
	IF U SAY SO
	
	HOW IZ I gettinLen
		FOUND YR ME'Z length
	IF U SAY SO
KTHX

I HAS A stack ITZ LIEK A pile

stack IZ pushin YR "testvalue" MKAY
stack IZ pushin YR "value2" MKAY
VISIBLE stack IZ popin MKAY
stack IZ pushin YR "lolcat" MKAY
stack IZ pushin YR "longcat" MKAY
VISIBLE stack IZ popin MKAY
VISIBLE stack IZ popin MKAY
VISIBLE stack IZ popin MKAY

KTHXBYE