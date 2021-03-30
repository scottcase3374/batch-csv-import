# BATCH CSV IMPORT

## About
I needed a method to load some open source data into a DB as part
of a pet project I am working on.

## Use
This SpringBoot Batch based import
1. Reads a CSV file
2. Sets a constructed key-value per row to a random UUID (for
demonstration purposes).
3. Writes the records out to a Postgresql DB.
4. Display the tables record count and timing info of load.
5. Ensure Java process cleanly exits.

## Data
The data comes from: https://www.kaggle.com/START-UMD/gtd

## Setup
The target database and most other config data is
configured in a K8s configmap that's read/handled by the
spring-cloud-starter-kubernetes-fabric8-all dependency.  The
bootstrap.yml file references the files/data needed to access
the K8s configmap.

## Execution
I run this within Eclipse via a SpringBoot run-configuration
which specifies the profiles: local,default,native,kubernetes,ide

### Performance
This runs for ~40-45 seconds on my system which is reasonable.  Since the source data and destination are a "normal" hard drive I didn't expect
must faster times.  If the data came from a NVME/SSD and the database was on a NVME/SSD then the load time would be much faster. Also note that
the amount of logging performed has a significant impact on performance.  I have implemented a batch solution at a prior employer where the result
seemed more scalable and efficient than this but the level of effort was high and I ended up with a "new custom batch framework" which
requires knowledge and maintenance over time.

## Benefits over SQL Loader / Import type tools
This method provided, in my opinion, better messages that helped
debug and resolve the import of some fields containing more complex
data (see column data scite1, scite2, scite3).  It did take repeated runs to get through the issues
but the issues were pretty clear. If the CSV fields were very
well defined beforehand then Liquibase or other methods would have worked just as well.
Because it took some experimentation to get the field
definitions "close enough" to successfully load though, this was
the better initial solution.

## Possible Enhancements
- Use K8s secret for Postgres DB password.
- Externalize file location.
- Add some test cases. Correctness was only verified through simple re-execution until I was able to get all data loaded.
- Improve the constraints on the fields.  There are some space efficiency improvements and more non-null columns can be defined.
- Make solution a bit more generic to allow more reuse for other potential (totally different) datasets later.
- Document fields better (make best guesses as to definitions for some).
- Cleanup required properties in bootstrap.yml file a little bit.
- Maybe decouple some of the class field / database field naming conventions.

## Credits - sites that provided a little or a lot of help in implementing this
- https://spring.io/guides/gs/batch-processing/
- https://howtodoinjava.com/spring-batch/java-config-multiple-steps/
- https://www.baeldung.com/spring-boot-spring-batch

## References
- http://scottcase.blogspot.com/2021/03/springboot-batch-load-csv-into.html

