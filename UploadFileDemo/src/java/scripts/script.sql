use test1;
DROP TABLE if exists image;
CREATE TABLE image (             
              id int(5) NOT NULL auto_increment, 
              image longblob,  
              name varchar(25) default NULL, 
              description varchar(200),
              extension varchar(5),
              PRIMARY KEY  (`id`)                   
 );
 ALTER TABLE image AUTO_INCREMENT = 1; -- to start from 1 when recreating the table.

DROP TABLE if exists article;
CREATE TABLE article(
id int(5) auto_increment,
headline varchar(50),
caption varchar(200),
body TEXT,
inserted TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO article (headline, caption, body) VALUES ('Hovedoverskrift her på artiklen', 'Dette er en smule tekst, som skal udgære en captiontekst som kan sættes med fed skrift lige ned under overskriften og som opsummere det der står i resten af artiklen', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Primum in nostrane potestate est, quid meminerimus? Qua ex cognitione facilior facta est investigatio rerum occultissimarum. Uterque enim summo bono fruitur, id est voluptate. Duo Reges: constructio interrete. Negat esse eam, inquit, propter se expetendam. Dolere malum est: in crucem qui agitur, beatus esse non potest. Si autem id non concedatur, non continuo vita beata tollitur. Omnes enim iucundum motum, quo sensus hilaretur. Longum est enim ad omnia respondere, quae a te dicta sunt. Est igitur officium eius generis, quod nec in bonis ponatur nec in contrariis. Te enim iudicem aequum puto, modo quae dicat ille bene noris. Non quam nostram quidem, inquit Pomponius iocans; Qui est in parvis malis. Omnes enim iucundum motum, quo sensus hilaretur. Conferam tecum, quam cuique verso rem subicias; Nam aliquando posse recte fieri dicunt nulla expectata nec quaesita voluptate. Non est igitur voluptas bonum. Age, inquies, ista parva sunt. Sed tamen intellego quid velit. Si qua in iis corrigere voluit, deteriora fecit. Nulla profecto est, quin suam vim retineat a primo ad extremum. Si enim, ut mihi quidem videtur, non explet bona naturae voluptas, iure praetermissa est; Hic ambiguo ludimur. Nonne videmus quanta perturbatio rerum omnium consequatur, quanta confusio? Color egregius, integra valitudo, summa gratia, vita denique conferta voluptatum omnium varietate. Ad eas enim res ab Epicuro praecepta dantur. Itaque nostrum est-quod nostrum dico, artis est-ad ea principia, quae accepimus. Sit enim idem caecus, debilis. Negat esse eam, inquit, propter se expetendam. Esse enim, nisi eris, non potes. Gerendus est mos, modo recte sentiat. Haec para/doca illi, nos admirabilia dicamus. Nihil minus, contraque illa hereditate dives ob eamque rem laetus.');