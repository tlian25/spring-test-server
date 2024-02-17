package com.txlian.testserver.util;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.args.BitCountOption;
import redis.clients.jedis.args.BitOP;
import redis.clients.jedis.args.ExpiryOption;
import redis.clients.jedis.args.FlushMode;
import redis.clients.jedis.args.FunctionRestorePolicy;
import redis.clients.jedis.args.GeoUnit;
import redis.clients.jedis.args.ListDirection;
import redis.clients.jedis.args.ListPosition;
import redis.clients.jedis.args.SortedSetOption;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.params.BitPosParams;
import redis.clients.jedis.params.GeoAddParams;
import redis.clients.jedis.params.GeoRadiusParam;
import redis.clients.jedis.params.GeoRadiusStoreParam;
import redis.clients.jedis.params.GeoSearchParam;
import redis.clients.jedis.params.GetExParams;
import redis.clients.jedis.params.LCSParams;
import redis.clients.jedis.params.LPosParams;
import redis.clients.jedis.params.MigrateParams;
import redis.clients.jedis.params.RestoreParams;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.params.SetParams;
import redis.clients.jedis.params.SortingParams;
import redis.clients.jedis.params.XAddParams;
import redis.clients.jedis.params.XAutoClaimParams;
import redis.clients.jedis.params.XClaimParams;
import redis.clients.jedis.params.XPendingParams;
import redis.clients.jedis.params.XReadGroupParams;
import redis.clients.jedis.params.XReadParams;
import redis.clients.jedis.params.XTrimParams;
import redis.clients.jedis.params.ZAddParams;
import redis.clients.jedis.params.ZIncrByParams;
import redis.clients.jedis.params.ZParams;
import redis.clients.jedis.params.ZRangeParams;
import redis.clients.jedis.resps.FunctionStats;
import redis.clients.jedis.resps.GeoRadiusResponse;
import redis.clients.jedis.resps.LCSMatchResult;
import redis.clients.jedis.resps.LibraryInfo;
import redis.clients.jedis.resps.ScanResult;
import redis.clients.jedis.resps.StreamConsumerInfo;
import redis.clients.jedis.resps.StreamConsumersInfo;
import redis.clients.jedis.resps.StreamEntry;
import redis.clients.jedis.resps.StreamFullInfo;
import redis.clients.jedis.resps.StreamGroupInfo;
import redis.clients.jedis.resps.StreamInfo;
import redis.clients.jedis.resps.StreamPendingEntry;
import redis.clients.jedis.resps.StreamPendingSummary;
import redis.clients.jedis.resps.Tuple;
import redis.clients.jedis.util.KeyValue;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LocalJedis implements JedisCommands {

    private static final Map<String, String> localstore = new ConcurrentHashMap<>();

    @Override
    public String set(String s, String s1) {
        localstore.put(s, s1);
        return s1;
    }

    @Override
    public String set(String s, String s1, SetParams setParams) {
        return null;
    }

    @Override
    public String get(String s) {
        return localstore.get(s);
    }

    @Override
    public long incr(String s) {
        String res = localstore.computeIfAbsent(s, (s1) -> "0");
        int curr = Integer.valueOf(res);
        localstore.put(s, String.valueOf(curr+1));
        return 0;
    }


    // ======================================================

    @Override
    public boolean setbit(String s, long l, boolean b) {
        return false;
    }

    @Override
    public boolean getbit(String s, long l) {
        return false;
    }

    @Override
    public long bitcount(String s) {
        return 0;
    }

    @Override
    public long bitcount(String s, long l, long l1) {
        return 0;
    }

    @Override
    public long bitcount(String s, long l, long l1, BitCountOption bitCountOption) {
        return 0;
    }

    @Override
    public long bitpos(String s, boolean b) {
        return 0;
    }

    @Override
    public long bitpos(String s, boolean b, BitPosParams bitPosParams) {
        return 0;
    }

    @Override
    public List<Long> bitfield(String s, String... strings) {
        return null;
    }

    @Override
    public List<Long> bitfieldReadonly(String s, String... strings) {
        return null;
    }

    @Override
    public long bitop(BitOP bitOP, String s, String... strings) {
        return 0;
    }

    @Override
    public Object fcall(String s, List<String> list, List<String> list1) {
        return null;
    }

    @Override
    public Object fcallReadonly(String s, List<String> list, List<String> list1) {
        return null;
    }

    @Override
    public String functionDelete(String s) {
        return null;
    }

    @Override
    public byte[] functionDump() {
        return new byte[0];
    }

    @Override
    public String functionFlush() {
        return null;
    }

    @Override
    public String functionFlush(FlushMode flushMode) {
        return null;
    }

    @Override
    public String functionKill() {
        return null;
    }

    @Override
    public List<LibraryInfo> functionList() {
        return null;
    }

    @Override
    public List<LibraryInfo> functionList(String s) {
        return null;
    }

    @Override
    public List<LibraryInfo> functionListWithCode() {
        return null;
    }

    @Override
    public List<LibraryInfo> functionListWithCode(String s) {
        return null;
    }

    @Override
    public String functionLoad(String s) {
        return null;
    }

    @Override
    public String functionLoadReplace(String s) {
        return null;
    }

    @Override
    public String functionRestore(byte[] bytes) {
        return null;
    }

    @Override
    public String functionRestore(byte[] bytes, FunctionRestorePolicy functionRestorePolicy) {
        return null;
    }

    @Override
    public FunctionStats functionStats() {
        return null;
    }

    @Override
    public long geoadd(String s, double v, double v1, String s1) {
        return 0;
    }

    @Override
    public long geoadd(String s, Map<String, GeoCoordinate> map) {
        return 0;
    }

    @Override
    public long geoadd(String s, GeoAddParams geoAddParams, Map<String, GeoCoordinate> map) {
        return 0;
    }

    @Override
    public Double geodist(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Double geodist(String s, String s1, String s2, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<String> geohash(String s, String... strings) {
        return null;
    }

    @Override
    public List<GeoCoordinate> geopos(String s, String... strings) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String s, double v, double v1, double v2, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusReadonly(String s, double v, double v1, double v2, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String s, double v, double v1, double v2, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusReadonly(String s, double v, double v1, double v2, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String s, String s1, double v, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMemberReadonly(String s, String s1, double v, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String s, String s1, double v, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMemberReadonly(String s, String s1, double v, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam) {
        return null;
    }

    @Override
    public long georadiusStore(String s, double v, double v1, double v2, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return 0;
    }

    @Override
    public long georadiusByMemberStore(String s, String s1, double v, GeoUnit geoUnit, GeoRadiusParam geoRadiusParam, GeoRadiusStoreParam geoRadiusStoreParam) {
        return 0;
    }

    @Override
    public List<GeoRadiusResponse> geosearch(String s, String s1, double v, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> geosearch(String s, GeoCoordinate geoCoordinate, double v, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> geosearch(String s, String s1, double v, double v1, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> geosearch(String s, GeoCoordinate geoCoordinate, double v, double v1, GeoUnit geoUnit) {
        return null;
    }

    @Override
    public List<GeoRadiusResponse> geosearch(String s, GeoSearchParam geoSearchParam) {
        return null;
    }

    @Override
    public long geosearchStore(String s, String s1, String s2, double v, GeoUnit geoUnit) {
        return 0;
    }

    @Override
    public long geosearchStore(String s, String s1, GeoCoordinate geoCoordinate, double v, GeoUnit geoUnit) {
        return 0;
    }

    @Override
    public long geosearchStore(String s, String s1, String s2, double v, double v1, GeoUnit geoUnit) {
        return 0;
    }

    @Override
    public long geosearchStore(String s, String s1, GeoCoordinate geoCoordinate, double v, double v1, GeoUnit geoUnit) {
        return 0;
    }

    @Override
    public long geosearchStore(String s, String s1, GeoSearchParam geoSearchParam) {
        return 0;
    }

    @Override
    public long geosearchStoreStoreDist(String s, String s1, GeoSearchParam geoSearchParam) {
        return 0;
    }

    @Override
    public long hset(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public long hset(String s, Map<String, String> map) {
        return 0;
    }

    @Override
    public String hget(String s, String s1) {
        return null;
    }

    @Override
    public long hsetnx(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public String hmset(String s, Map<String, String> map) {
        return null;
    }

    @Override
    public List<String> hmget(String s, String... strings) {
        return null;
    }

    @Override
    public long hincrBy(String s, String s1, long l) {
        return 0;
    }

    @Override
    public double hincrByFloat(String s, String s1, double v) {
        return 0;
    }

    @Override
    public boolean hexists(String s, String s1) {
        return false;
    }

    @Override
    public long hdel(String s, String... strings) {
        return 0;
    }

    @Override
    public long hlen(String s) {
        return 0;
    }

    @Override
    public Set<String> hkeys(String s) {
        return null;
    }

    @Override
    public List<String> hvals(String s) {
        return null;
    }

    @Override
    public Map<String, String> hgetAll(String s) {
        return null;
    }

    @Override
    public String hrandfield(String s) {
        return null;
    }

    @Override
    public List<String> hrandfield(String s, long l) {
        return null;
    }

    @Override
    public List<Map.Entry<String, String>> hrandfieldWithValues(String s, long l) {
        return null;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String s, String s1, ScanParams scanParams) {
        return null;
    }

    @Override
    public long hstrlen(String s, String s1) {
        return 0;
    }

    @Override
    public long pfadd(String s, String... strings) {
        return 0;
    }

    @Override
    public String pfmerge(String s, String... strings) {
        return null;
    }

    @Override
    public long pfcount(String s) {
        return 0;
    }

    @Override
    public long pfcount(String... strings) {
        return 0;
    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public long exists(String... strings) {
        return 0;
    }

    @Override
    public long persist(String s) {
        return 0;
    }

    @Override
    public String type(String s) {
        return null;
    }

    @Override
    public byte[] dump(String s) {
        return new byte[0];
    }

    @Override
    public String restore(String s, long l, byte[] bytes) {
        return null;
    }

    @Override
    public String restore(String s, long l, byte[] bytes, RestoreParams restoreParams) {
        return null;
    }

    @Override
    public long expire(String s, long l) {
        return 0;
    }

    @Override
    public long expire(String s, long l, ExpiryOption expiryOption) {
        return 0;
    }

    @Override
    public long pexpire(String s, long l) {
        return 0;
    }

    @Override
    public long pexpire(String s, long l, ExpiryOption expiryOption) {
        return 0;
    }

    @Override
    public long expireTime(String s) {
        return 0;
    }

    @Override
    public long pexpireTime(String s) {
        return 0;
    }

    @Override
    public long expireAt(String s, long l) {
        return 0;
    }

    @Override
    public long expireAt(String s, long l, ExpiryOption expiryOption) {
        return 0;
    }

    @Override
    public long pexpireAt(String s, long l) {
        return 0;
    }

    @Override
    public long pexpireAt(String s, long l, ExpiryOption expiryOption) {
        return 0;
    }

    @Override
    public long ttl(String s) {
        return 0;
    }

    @Override
    public long pttl(String s) {
        return 0;
    }

    @Override
    public long touch(String s) {
        return 0;
    }

    @Override
    public long touch(String... strings) {
        return 0;
    }

    @Override
    public List<String> sort(String s) {
        return null;
    }

    @Override
    public long sort(String s, String s1) {
        return 0;
    }

    @Override
    public List<String> sort(String s, SortingParams sortingParams) {
        return null;
    }

    @Override
    public long sort(String s, SortingParams sortingParams, String s1) {
        return 0;
    }

    @Override
    public List<String> sortReadonly(String s, SortingParams sortingParams) {
        return null;
    }

    @Override
    public long del(String s) {
        return 0;
    }

    @Override
    public long del(String... strings) {
        return 0;
    }

    @Override
    public long unlink(String s) {
        return 0;
    }

    @Override
    public long unlink(String... strings) {
        return 0;
    }

    @Override
    public boolean copy(String s, String s1, boolean b) {
        return false;
    }

    @Override
    public String rename(String s, String s1) {
        return null;
    }

    @Override
    public long renamenx(String s, String s1) {
        return 0;
    }

    @Override
    public Long memoryUsage(String s) {
        return null;
    }

    @Override
    public Long memoryUsage(String s, int i) {
        return null;
    }

    @Override
    public Long objectRefcount(String s) {
        return null;
    }

    @Override
    public String objectEncoding(String s) {
        return null;
    }

    @Override
    public Long objectIdletime(String s) {
        return null;
    }

    @Override
    public Long objectFreq(String s) {
        return null;
    }

    @Override
    public String migrate(String s, int i, String s1, int i1) {
        return null;
    }

    @Override
    public String migrate(String s, int i, int i1, MigrateParams migrateParams, String... strings) {
        return null;
    }

    @Override
    public Set<String> keys(String s) {
        return null;
    }

    @Override
    public ScanResult<String> scan(String s) {
        return null;
    }

    @Override
    public ScanResult<String> scan(String s, ScanParams scanParams) {
        return null;
    }

    @Override
    public ScanResult<String> scan(String s, ScanParams scanParams, String s1) {
        return null;
    }

    @Override
    public String randomKey() {
        return null;
    }

    @Override
    public long rpush(String s, String... strings) {
        return 0;
    }

    @Override
    public long lpush(String s, String... strings) {
        return 0;
    }

    @Override
    public long llen(String s) {
        return 0;
    }

    @Override
    public List<String> lrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public String ltrim(String s, long l, long l1) {
        return null;
    }

    @Override
    public String lindex(String s, long l) {
        return null;
    }

    @Override
    public String lset(String s, long l, String s1) {
        return null;
    }

    @Override
    public long lrem(String s, long l, String s1) {
        return 0;
    }

    @Override
    public String lpop(String s) {
        return null;
    }

    @Override
    public List<String> lpop(String s, int i) {
        return null;
    }

    @Override
    public Long lpos(String s, String s1) {
        return null;
    }

    @Override
    public Long lpos(String s, String s1, LPosParams lPosParams) {
        return null;
    }

    @Override
    public List<Long> lpos(String s, String s1, LPosParams lPosParams, long l) {
        return null;
    }

    @Override
    public String rpop(String s) {
        return null;
    }

    @Override
    public List<String> rpop(String s, int i) {
        return null;
    }

    @Override
    public long linsert(String s, ListPosition listPosition, String s1, String s2) {
        return 0;
    }

    @Override
    public long lpushx(String s, String... strings) {
        return 0;
    }

    @Override
    public long rpushx(String s, String... strings) {
        return 0;
    }

    @Override
    public List<String> blpop(int i, String... strings) {
        return null;
    }

    @Override
    public List<String> blpop(int i, String s) {
        return null;
    }

    @Override
    public KeyValue<String, String> blpop(double v, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, String> blpop(double v, String s) {
        return null;
    }

    @Override
    public List<String> brpop(int i, String... strings) {
        return null;
    }

    @Override
    public List<String> brpop(int i, String s) {
        return null;
    }

    @Override
    public KeyValue<String, String> brpop(double v, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, String> brpop(double v, String s) {
        return null;
    }

    @Override
    public String rpoplpush(String s, String s1) {
        return null;
    }

    @Override
    public String brpoplpush(String s, String s1, int i) {
        return null;
    }

    @Override
    public String lmove(String s, String s1, ListDirection listDirection, ListDirection listDirection1) {
        return null;
    }

    @Override
    public String blmove(String s, String s1, ListDirection listDirection, ListDirection listDirection1, double v) {
        return null;
    }

    @Override
    public KeyValue<String, List<String>> lmpop(ListDirection listDirection, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, List<String>> lmpop(ListDirection listDirection, int i, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, List<String>> blmpop(double v, ListDirection listDirection, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, List<String>> blmpop(double v, ListDirection listDirection, int i, String... strings) {
        return null;
    }

    @Override
    public Object eval(String s) {
        return null;
    }

    @Override
    public Object eval(String s, int i, String... strings) {
        return null;
    }

    @Override
    public Object eval(String s, List<String> list, List<String> list1) {
        return null;
    }

    @Override
    public Object evalReadonly(String s, List<String> list, List<String> list1) {
        return null;
    }

    @Override
    public Object evalsha(String s) {
        return null;
    }

    @Override
    public Object evalsha(String s, int i, String... strings) {
        return null;
    }

    @Override
    public Object evalsha(String s, List<String> list, List<String> list1) {
        return null;
    }

    @Override
    public Object evalshaReadonly(String s, List<String> list, List<String> list1) {
        return null;
    }

    @Override
    public long sadd(String s, String... strings) {
        return 0;
    }

    @Override
    public Set<String> smembers(String s) {
        return null;
    }

    @Override
    public long srem(String s, String... strings) {
        return 0;
    }

    @Override
    public String spop(String s) {
        return null;
    }

    @Override
    public Set<String> spop(String s, long l) {
        return null;
    }

    @Override
    public long scard(String s) {
        return 0;
    }

    @Override
    public boolean sismember(String s, String s1) {
        return false;
    }

    @Override
    public List<Boolean> smismember(String s, String... strings) {
        return null;
    }

    @Override
    public String srandmember(String s) {
        return null;
    }

    @Override
    public List<String> srandmember(String s, int i) {
        return null;
    }

    @Override
    public ScanResult<String> sscan(String s, String s1, ScanParams scanParams) {
        return null;
    }

    @Override
    public Set<String> sdiff(String... strings) {
        return null;
    }

    @Override
    public long sdiffstore(String s, String... strings) {
        return 0;
    }

    @Override
    public Set<String> sinter(String... strings) {
        return null;
    }

    @Override
    public long sinterstore(String s, String... strings) {
        return 0;
    }

    @Override
    public long sintercard(String... strings) {
        return 0;
    }

    @Override
    public long sintercard(int i, String... strings) {
        return 0;
    }

    @Override
    public Set<String> sunion(String... strings) {
        return null;
    }

    @Override
    public long sunionstore(String s, String... strings) {
        return 0;
    }

    @Override
    public long smove(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public long zadd(String s, double v, String s1) {
        return 0;
    }

    @Override
    public long zadd(String s, double v, String s1, ZAddParams zAddParams) {
        return 0;
    }

    @Override
    public long zadd(String s, Map<String, Double> map) {
        return 0;
    }

    @Override
    public long zadd(String s, Map<String, Double> map, ZAddParams zAddParams) {
        return 0;
    }

    @Override
    public Double zaddIncr(String s, double v, String s1, ZAddParams zAddParams) {
        return null;
    }

    @Override
    public long zrem(String s, String... strings) {
        return 0;
    }

    @Override
    public double zincrby(String s, double v, String s1) {
        return 0;
    }

    @Override
    public Double zincrby(String s, double v, String s1, ZIncrByParams zIncrByParams) {
        return null;
    }

    @Override
    public Long zrank(String s, String s1) {
        return null;
    }

    @Override
    public Long zrevrank(String s, String s1) {
        return null;
    }

    @Override
    public KeyValue<Long, Double> zrankWithScore(String s, String s1) {
        return null;
    }

    @Override
    public KeyValue<Long, Double> zrevrankWithScore(String s, String s1) {
        return null;
    }

    @Override
    public List<String> zrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public List<String> zrevrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public List<Tuple> zrangeWithScores(String s, long l, long l1) {
        return null;
    }

    @Override
    public List<Tuple> zrevrangeWithScores(String s, long l, long l1) {
        return null;
    }

    @Override
    public List<String> zrange(String s, ZRangeParams zRangeParams) {
        return null;
    }

    @Override
    public List<Tuple> zrangeWithScores(String s, ZRangeParams zRangeParams) {
        return null;
    }

    @Override
    public long zrangestore(String s, String s1, ZRangeParams zRangeParams) {
        return 0;
    }

    @Override
    public String zrandmember(String s) {
        return null;
    }

    @Override
    public List<String> zrandmember(String s, long l) {
        return null;
    }

    @Override
    public List<Tuple> zrandmemberWithScores(String s, long l) {
        return null;
    }

    @Override
    public long zcard(String s) {
        return 0;
    }

    @Override
    public Double zscore(String s, String s1) {
        return null;
    }

    @Override
    public List<Double> zmscore(String s, String... strings) {
        return null;
    }

    @Override
    public Tuple zpopmax(String s) {
        return null;
    }

    @Override
    public List<Tuple> zpopmax(String s, int i) {
        return null;
    }

    @Override
    public Tuple zpopmin(String s) {
        return null;
    }

    @Override
    public List<Tuple> zpopmin(String s, int i) {
        return null;
    }

    @Override
    public long zcount(String s, double v, double v1) {
        return 0;
    }

    @Override
    public long zcount(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public List<String> zrangeByScore(String s, double v, double v1) {
        return null;
    }

    @Override
    public List<String> zrangeByScore(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<String> zrevrangeByScore(String s, double v, double v1) {
        return null;
    }

    @Override
    public List<String> zrangeByScore(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public List<String> zrevrangeByScore(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<String> zrangeByScore(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public List<String> zrevrangeByScore(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public List<Tuple> zrangeByScoreWithScores(String s, double v, double v1) {
        return null;
    }

    @Override
    public List<Tuple> zrevrangeByScoreWithScores(String s, double v, double v1) {
        return null;
    }

    @Override
    public List<Tuple> zrangeByScoreWithScores(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public List<String> zrevrangeByScore(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public List<Tuple> zrangeByScoreWithScores(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<Tuple> zrevrangeByScoreWithScores(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<Tuple> zrangeByScoreWithScores(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public List<Tuple> zrevrangeByScoreWithScores(String s, double v, double v1, int i, int i1) {
        return null;
    }

    @Override
    public List<Tuple> zrevrangeByScoreWithScores(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public long zremrangeByRank(String s, long l, long l1) {
        return 0;
    }

    @Override
    public long zremrangeByScore(String s, double v, double v1) {
        return 0;
    }

    @Override
    public long zremrangeByScore(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public long zlexcount(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public List<String> zrangeByLex(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<String> zrangeByLex(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public List<String> zrevrangeByLex(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<String> zrevrangeByLex(String s, String s1, String s2, int i, int i1) {
        return null;
    }

    @Override
    public long zremrangeByLex(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public ScanResult<Tuple> zscan(String s, String s1, ScanParams scanParams) {
        return null;
    }

    @Override
    public KeyValue<String, Tuple> bzpopmax(double v, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, Tuple> bzpopmin(double v, String... strings) {
        return null;
    }

    @Override
    public List<String> zdiff(String... strings) {
        return null;
    }

    @Override
    public List<Tuple> zdiffWithScores(String... strings) {
        return null;
    }

    @Override
    public long zdiffStore(String s, String... strings) {
        return 0;
    }

    @Override
    public long zdiffstore(String s, String... strings) {
        return 0;
    }

    @Override
    public List<String> zinter(ZParams zParams, String... strings) {
        return null;
    }

    @Override
    public List<Tuple> zinterWithScores(ZParams zParams, String... strings) {
        return null;
    }

    @Override
    public long zinterstore(String s, String... strings) {
        return 0;
    }

    @Override
    public long zinterstore(String s, ZParams zParams, String... strings) {
        return 0;
    }

    @Override
    public long zintercard(String... strings) {
        return 0;
    }

    @Override
    public long zintercard(long l, String... strings) {
        return 0;
    }

    @Override
    public List<String> zunion(ZParams zParams, String... strings) {
        return null;
    }

    @Override
    public List<Tuple> zunionWithScores(ZParams zParams, String... strings) {
        return null;
    }

    @Override
    public long zunionstore(String s, String... strings) {
        return 0;
    }

    @Override
    public long zunionstore(String s, ZParams zParams, String... strings) {
        return 0;
    }

    @Override
    public KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, int i, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, List<Tuple>> bzmpop(double v, SortedSetOption sortedSetOption, String... strings) {
        return null;
    }

    @Override
    public KeyValue<String, List<Tuple>> bzmpop(double v, SortedSetOption sortedSetOption, int i, String... strings) {
        return null;
    }

    @Override
    public StreamEntryID xadd(String s, StreamEntryID streamEntryID, Map<String, String> map) {
        return null;
    }

    @Override
    public StreamEntryID xadd(String s, XAddParams xAddParams, Map<String, String> map) {
        return null;
    }

    @Override
    public long xlen(String s) {
        return 0;
    }

    @Override
    public List<StreamEntry> xrange(String s, StreamEntryID streamEntryID, StreamEntryID streamEntryID1) {
        return null;
    }

    @Override
    public List<StreamEntry> xrange(String s, StreamEntryID streamEntryID, StreamEntryID streamEntryID1, int i) {
        return null;
    }

    @Override
    public List<StreamEntry> xrevrange(String s, StreamEntryID streamEntryID, StreamEntryID streamEntryID1) {
        return null;
    }

    @Override
    public List<StreamEntry> xrevrange(String s, StreamEntryID streamEntryID, StreamEntryID streamEntryID1, int i) {
        return null;
    }

    @Override
    public List<StreamEntry> xrange(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<StreamEntry> xrange(String s, String s1, String s2, int i) {
        return null;
    }

    @Override
    public List<StreamEntry> xrevrange(String s, String s1, String s2) {
        return null;
    }

    @Override
    public List<StreamEntry> xrevrange(String s, String s1, String s2, int i) {
        return null;
    }

    @Override
    public long xack(String s, String s1, StreamEntryID... streamEntryIDS) {
        return 0;
    }

    @Override
    public String xgroupCreate(String s, String s1, StreamEntryID streamEntryID, boolean b) {
        return null;
    }

    @Override
    public String xgroupSetID(String s, String s1, StreamEntryID streamEntryID) {
        return null;
    }

    @Override
    public long xgroupDestroy(String s, String s1) {
        return 0;
    }

    @Override
    public boolean xgroupCreateConsumer(String s, String s1, String s2) {
        return false;
    }

    @Override
    public long xgroupDelConsumer(String s, String s1, String s2) {
        return 0;
    }

    @Override
    public long xdel(String s, StreamEntryID... streamEntryIDS) {
        return 0;
    }

    @Override
    public long xtrim(String s, long l, boolean b) {
        return 0;
    }

    @Override
    public long xtrim(String s, XTrimParams xTrimParams) {
        return 0;
    }

    @Override
    public StreamPendingSummary xpending(String s, String s1) {
        return null;
    }

    @Override
    public List<StreamPendingEntry> xpending(String s, String s1, XPendingParams xPendingParams) {
        return null;
    }

    @Override
    public List<StreamEntry> xclaim(String s, String s1, String s2, long l, XClaimParams xClaimParams, StreamEntryID... streamEntryIDS) {
        return null;
    }

    @Override
    public List<StreamEntryID> xclaimJustId(String s, String s1, String s2, long l, XClaimParams xClaimParams, StreamEntryID... streamEntryIDS) {
        return null;
    }

    @Override
    public Map.Entry<StreamEntryID, List<StreamEntry>> xautoclaim(String s, String s1, String s2, long l, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return null;
    }

    @Override
    public Map.Entry<StreamEntryID, List<StreamEntryID>> xautoclaimJustId(String s, String s1, String s2, long l, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams) {
        return null;
    }

    @Override
    public StreamInfo xinfoStream(String s) {
        return null;
    }

    @Override
    public StreamFullInfo xinfoStreamFull(String s) {
        return null;
    }

    @Override
    public StreamFullInfo xinfoStreamFull(String s, int i) {
        return null;
    }

    @Override
    public List<StreamGroupInfo> xinfoGroups(String s) {
        return null;
    }

    @Override
    public List<StreamConsumersInfo> xinfoConsumers(String s, String s1) {
        return null;
    }

    @Override
    public List<StreamConsumerInfo> xinfoConsumers2(String s, String s1) {
        return null;
    }

    @Override
    public List<Map.Entry<String, List<StreamEntry>>> xread(XReadParams xReadParams, Map<String, StreamEntryID> map) {
        return null;
    }

    @Override
    public List<Map.Entry<String, List<StreamEntry>>> xreadGroup(String s, String s1, XReadGroupParams xReadGroupParams, Map<String, StreamEntryID> map) {
        return null;
    }

    @Override
    public String setGet(String s, String s1) {
        return null;
    }

    @Override
    public String setGet(String s, String s1, SetParams setParams) {
        return null;
    }

    @Override
    public String getDel(String s) {
        return null;
    }

    @Override
    public String getEx(String s, GetExParams getExParams) {
        return null;
    }

    @Override
    public long setrange(String s, long l, String s1) {
        return 0;
    }

    @Override
    public String getrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public String getSet(String s, String s1) {
        return null;
    }

    @Override
    public long setnx(String s, String s1) {
        return 0;
    }

    @Override
    public String setex(String s, long l, String s1) {
        return null;
    }

    @Override
    public String psetex(String s, long l, String s1) {
        return null;
    }

    @Override
    public List<String> mget(String... strings) {
        return null;
    }

    @Override
    public String mset(String... strings) {
        return null;
    }

    @Override
    public long msetnx(String... strings) {
        return 0;
    }



    @Override
    public long incrBy(String s, long l) {
        return 0;
    }

    @Override
    public double incrByFloat(String s, double v) {
        return 0;
    }

    @Override
    public long decr(String s) {
        return 0;
    }

    @Override
    public long decrBy(String s, long l) {
        return 0;
    }

    @Override
    public long append(String s, String s1) {
        return 0;
    }

    @Override
    public String substr(String s, int i, int i1) {
        return null;
    }

    @Override
    public long strlen(String s) {
        return 0;
    }

    @Override
    public LCSMatchResult lcs(String s, String s1, LCSParams lcsParams) {
        return null;
    }
}
