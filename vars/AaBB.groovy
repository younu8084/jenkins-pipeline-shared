
def call()
{
baseUrlv2 = "http://18.224.68.30:7990/rest/api/1.0"
baseUrlv1 = "http://18.224.68.30:7990/rest/api/1.0"

username = "rig"
password = "rigaDapt@devOps"
year = 2020

totalCommits = 0
commitCount = 0
commits = []

print ""
print "Stats for {year}".format(year=year)
print ""

r = requests.get("{base}/user/repositories/".format(base=baseUrlv1),
auth=(username , password))

repos = r.json()

for repo in repos:
	repoSlug = repo['slug']
	r = requests.get("{base}/repositories/{username}/{repo}/commits".format(base=baseUrlv2, username=username, repo=repoSlug),
	auth=(username, password))

	c = r.json()
	commits.extend(c['values'])

	while 'next' in c:
		r = requests.get("{next}".format(next=c['next']), 
			auth=(username, password))
		c = r.json()
		commits.extend(c['values'])

	for commit in commits:
		commitDate = dateutil.parser.parse(commit['date'])
		if commitDate.year == year:
			commitCount += 1

			r = requests.get("{base}/repositories/{username}/{repo}/changesets/{hash}/diffstat/".format(base=baseUrlv1, username=username, repo=repoSlug, hash=commit['hash']),
				auth=(username, password))
			
			try:
				stats = r.json()
			except ValueError:
			    # decoding failed
			    continue

	print "Total commits in {user}/{repo}: {count}".format(user=username, repo=repoSlug, count=commitCount)	
	totalCommits += commitCount	

	#reset counters
	commitCount = 0
	commits = []

print ""
print "Total commits: {count}".format(count=totalCommits)


}
