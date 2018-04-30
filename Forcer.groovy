// Idea from https://community.atlassian.com/t5/Jira-questions/JIRA-default-comment-visibility-via-ScriptRunner-Behaviors/qaq-p/136377
// 
//Modifications:
// To be used as Jira Script Runner Behaviours / Initializer  
// 
// Set Comment level automaticly
// As thread says , works ok in Edit screen, but normal (View) screen and adding comment does not set the comment visibility  role
//
// April 2018    mika.nokka1@gmail.com   


package com.onresolve.jira.groovy.doit4  // this script must be living under this tree starting from /scripts directory (<jira place>/scripts/com/resolve....)
import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Logger
import org.apache.log4j.Level
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.MutableIssue
import com.onresolve.jira.groovy.user.FieldBehaviours   // class to be used if script in server
import com.atlassian.jira.issue.IssueManager
import static com.atlassian.jira.issue.IssueFieldConstants.*  // can use things like AFFECTED_VERSIONS see: https://docs.atlassian.com/software/jira/docs/api/7.6.1/constant-values.html#com.atlassian.jira.issue.IssueFieldConstants.FIX_FOR_VERSIONS
import com.onresolve.jira.groovy.user.FormField

public class Forcer extends FieldBehaviours {

void Doit4() {	// just a method runtime system is calling (used in Behaviours configurations)
	
		def log = Logger.getLogger("CommentForcer")
		log.setLevel(Level.DEBUG) // DEBUG INFO
	
		log.debug("---------- CommentForcer started ---------------------------------------")
		def issue="NOT_EXISTS"
		FormField commentSec = getFieldById("commentLevel")
		issue=underlyingIssue // from ScriptRunner example code	
		
		log.debug("issue:${issue}")
		log.debug("commentSec:${commentSec}")
		commentSec.setFormValue("role:10400") // just test

		log.debug("---------- CommentForcer stopped ---------------------------------------")
	}
}
